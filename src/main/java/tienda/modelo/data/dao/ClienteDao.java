package tienda.modelo.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import tienda.modelo.Cliente;
import tienda.modelo.Dni;
import tienda.modelo.data.ConexionBD;
import tienda.modelo.exception.LetraDniIncorrectaException;

public class ClienteDao {
    private Connection connection;

    private static final String GUARDAR_CLIENTE = "INSERT INTO Cliente (numDni,letraDni,login,clave,nombre,apellidos,direccion,fechaNacimiento, idCarrito) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String BUSCAR_POR_LOGIN = "SELECT numDni,letraDni,login,clave,nombre,apellidos,direccion,fechaNacimiento,idCarrito  FROM Cliente WHERE login=?";

    //Constructor, carga driver
    public ClienteDao() {
        this.connection = ConexionBD.getConexionDB().getConexion();
    }

    public void guardarCliente(Cliente cliente, int numCarrito) throws SQLException {
        //stableces concexion
        PreparedStatement statement = connection.prepareStatement(GUARDAR_CLIENTE);
        statement.setInt(1, cliente.getDni().getNumero());
        statement.setString(2, Character.toString(cliente.getDni().getLetra()));
        statement.setString(3, cliente.getLogin());
        statement.setString(4, cliente.getClave());
        statement.setString(5, cliente.getNombre());
        statement.setString(6, cliente.getApellidos());
        statement.setString(7, cliente.getDireccion());
        statement.setDate(8, new Date(cliente.getFechaNacimiento().getTimeInMillis()));
        statement.setInt(9, numCarrito);
        int numFilas = statement.executeUpdate();

    }

    /**
     * @param login
     * @return el cliente buscado o null si no lo encuentra
     * @throws SQLException
     * @throws LetraDniIncorrectaException
     */

    public Cliente buscarPorLogin(String login) throws SQLException, LetraDniIncorrectaException {

        PreparedStatement statement = connection.prepareStatement(BUSCAR_POR_LOGIN);
        statement.setString(1, login);
        ResultSet resultado = statement.executeQuery();
        Cliente cliente = null;
        if (resultado.next()) {
            int numDni = resultado.getInt("numDni");
            char letraDni = resultado.getString("letraDni").charAt(0);

            Dni dni = new Dni(numDni, letraDni);

            String clave = resultado.getString("clave");
            String nombre = resultado.getString("nombre");
            String apellidos = resultado.getString("apellidos");
            String direccion = resultado.getString("direccion");
            Calendar fechaNacimiento = Calendar.getInstance();
            fechaNacimiento.setTimeInMillis(resultado.getDate("fechaNacimiento").getTime());
            int idCarrito = resultado.getInt("idCarrito");
            cliente = new Cliente(dni, login, clave, nombre, apellidos, direccion, fechaNacimiento, idCarrito);

        }
        return cliente;

    }

}
