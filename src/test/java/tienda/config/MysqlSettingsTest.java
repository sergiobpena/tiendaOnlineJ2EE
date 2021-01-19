package tienda.config;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;
public class MysqlSettingsTest {
    @Test
  public void conexionMysqlTest(){
        boolean test = true;
        DbSettings dbSettings = MysqlSettings.getMysqlSetting();
        String DRIVER_CLASS="com.mysql.jdbc.Driver";
        String CONNECTIO_URL="jdbc:mysql://"+ dbSettings.getHost()+":"+dbSettings.getPort()+"/"+dbSettings.getDb();
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            test=false;
        }
        try {
            Connection connection = DriverManager.getConnection(CONNECTIO_URL, dbSettings.getUser(),dbSettings.getPass());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            test=false;
        }
        assertTrue(test);
  }
}