package tienda.modelo.data;

import org.apache.log4j.Logger;
import tienda.config.DbSettings;
import tienda.config.MysqlSettings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    static Logger log = Logger.getLogger(ConexionBD.class.getName());

    private static ConexionBD conexionDB;
    private Connection conexion;

    private ConexionBD(){
        this.conectar();
    }

    private void conectar(){
        DbSettings dbSettings = MysqlSettings.getMysqlSetting();
        try{
            this.conexion= DriverManager.getConnection("jdbc:mysql://" + dbSettings.getHost() + ":"
                    +dbSettings.getPort()+"/"+dbSettings.getDb(),dbSettings.getUser(),dbSettings.getPass());
//            this.conexion.setAutoCommit(false);
            log.info("Conexion bd realizada");

        }catch (SQLException e){
            log.error("Non se puido establecer conexion con bd");
            e.printStackTrace();
        }
    }


    public void desconectar(){
        try{
            if(this.conexion!=null){
                this.conexion.close();
                log.info("Desconexion con bd");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static ConexionBD getConexionDB (){
        if(conexionDB == null){
            conexionDB=new ConexionBD();
        }
        return conexionDB;
    }

    public Connection getConexion() {
        return this.conexion;
    }
}
