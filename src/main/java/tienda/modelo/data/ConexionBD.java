package tienda.modelo.data;

import org.apache.log4j.Logger;
import tienda.config.DbSettings;
import tienda.config.MysqlSettings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {


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
            System.out.println("Conexion realizada");

        }catch (SQLException e){
            System.out.println("Non se realizou conexion");
            e.printStackTrace();
        }
    }


    public void desconectar(){
        try{
            if(this.conexion!=null){
                this.conexion.close();
                System.out.println("Conexion pechada");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static ConexionBD getConexionDB (String ruta){
        if(conexionDB == null){
            conexionDB=new ConexionBD();
        }
        return conexionDB;
    }

    public Connection getConexion() {
        return this.conexion;
    }
}
