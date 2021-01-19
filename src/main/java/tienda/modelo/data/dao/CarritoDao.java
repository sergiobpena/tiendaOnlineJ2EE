package tienda.modelo.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tienda.modelo.CarritoCollections;
import tienda.modelo.Producto;
import tienda.modelo.data.ConexionBD;
import tienda.modelo.exception.CarritoLlenoException;


public class CarritoDao {

    private Connection connection;
    private static final String CREAR_CARRITO = "INSERT INTO Carrito VALUES()";
    private static final String BUSCAR_CARRITO = "select * from DetallesCarrito dc join Producto p on dc.idproducto=p.idproducto where dc.idCarrito=?";


    public CarritoDao() {
        this.connection = ConexionBD.getConexionDB().getConexion();
    }

    /**
     * @return o id de carrito generado ou 0 se non se puido xerar
     * @throws SQLException
     */

    public int crearCarrito() throws SQLException {

        Statement statement = connection.createStatement();
        int numFilas = statement.executeUpdate(CREAR_CARRITO, Statement.RETURN_GENERATED_KEYS);
        int idCarrito = 0;
        if (numFilas == 1) {
            ResultSet resultado = statement.getGeneratedKeys();
            if (resultado.next()) {
                idCarrito = resultado.getInt(1);
                return idCarrito;
            }

        }
        return idCarrito;


    }

    public CarritoCollections buscarPorIdCarrito(int numCarrito) throws SQLException, CarritoLlenoException {

        PreparedStatement statement = connection.prepareStatement(BUSCAR_CARRITO);


        statement.setInt(1, numCarrito);
        ResultSet resultado = statement.executeQuery();
        CarritoCollections carrito = new CarritoCollections(null);
        while (resultado.next()) {
            int numProducto = resultado.getInt("idProducto");
            String titulo = resultado.getString("titulo");
            double precio = resultado.getDouble("precio");
            String genero = resultado.getString("genero");
            int anho = resultado.getInt("anho");
            Producto p = new Producto(numProducto, titulo, genero, precio, anho);
            carrito.meterEnCarrito(p);

        }
        return carrito;
    }

}
