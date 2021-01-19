package tienda.modelo.data.dao;

import tienda.modelo.Libro;
import tienda.modelo.Pelicula;
import tienda.modelo.Producto;
import tienda.modelo.data.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductoDAO {

	private Connection connection;
	private static final String CONSULTA_LIBROS="select * from Producto p join Libro l on p.idProducto = l.idproducto";
	private static final String CONSULTA_PELICULAS="select * from Producto p join Pelicula pel on p.idProducto = pel.idproducto";
	
	public ProductoDAO () {
		this.connection= ConexionBD.getConexionDB().getConexion();
	}

	public List<Producto> buscarTodos() throws SQLException {

			PreparedStatement statement = connection.prepareStatement(CONSULTA_LIBROS);
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
