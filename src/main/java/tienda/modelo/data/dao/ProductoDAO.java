package tienda.modelo.data.dao;

import tienda.modelo.Libro;
import tienda.modelo.Pelicula;
import tienda.modelo.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductoDAO {
	
	private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private final String CONNECTIO_URL="jdbc:mysql://localhost/curso?user=root";
	private static final String CONSULTA_LIBROS="select * from producto p join libro l on p.idProducto = l.idproducto";
	private static final String CONSULTA_PELICULAS="select * from producto p join pelicula pel on p.idProducto = pel.idproducto";
	
	public ProductoDAO () {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Producto> buscarTodos() throws SQLException {
		try (Connection connection = DriverManager.getConnection(CONNECTIO_URL);
			PreparedStatement statement = connection.prepareStatement(CONSULTA_LIBROS);) {
			List<Producto> lista = new ArrayList<>();
			ResultSet resultadoLibros = statement.executeQuery(CONSULTA_LIBROS);
			while (resultadoLibros.next()) {
				int idProducto = resultadoLibros.getInt("idProducto");
				String titulo = resultadoLibros.getString("titulo");
				double precio = resultadoLibros.getDouble("precio");
				int anho = resultadoLibros.getInt("anho");
				String genero = resultadoLibros.getString("genero");
				String autor = resultadoLibros.getString("autor");
				String isbn = resultadoLibros.getString("isbn");
				Libro lib = new Libro(idProducto, titulo, genero, precio, anho, autor, isbn);
				lista.add(lib);
			}
			ResultSet resultadoPelis = statement.executeQuery(CONSULTA_PELICULAS);
			while (resultadoPelis.next()) {
				int idProducto = resultadoPelis.getInt("idProducto");
				String titulo = resultadoPelis.getString("titulo");
				double precio = resultadoPelis.getDouble("precio");
				int anho = resultadoPelis.getInt("anho");
				String genero = resultadoPelis.getString("genero");
				String director = resultadoPelis.getString("directo");
				String reparto = resultadoPelis.getString("reparto");
				Pelicula p = new Pelicula(idProducto, titulo, genero, precio, anho, director, reparto);
				lista.add(p);
			}
			return lista;
		} 

	}
	

}
