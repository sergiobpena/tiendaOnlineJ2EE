package tienda.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class MysqlSettings implements DbSettings{

    private static MysqlSettings mysqlsettings=null;
    private Properties properties;

    private MysqlSettings (){

        URL resouce= getClass().getClassLoader().getResource("bd.properties");
        try {
            File ArquivoProperties=new File(resouce.toURI());
            FileInputStream fis = new FileInputStream(ArquivoProperties);
            this.properties = new Properties();
            this.properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static MysqlSettings getMysqlSetting(){
        if (mysqlsettings == null){
            mysqlsettings=new MysqlSettings();
        }
        return mysqlsettings;
    }
    @Override
    public String getHost() {
        return this.properties.getProperty("MYSQL_HOST");
    }

    @Override
    public String getPort() {
        return this.properties.getProperty("MYSQL_PORT");
    }

    @Override
    public String getUser() {
        return this.properties.getProperty("MYSQL_USER");
    }

    @Override
    public String getPass() {
        return this.properties.getProperty("MYSQL_PASSWORD");
    }

    @Override
    public String getDb() {
        return this.properties.getProperty("MYSQL_DB");
    }
}
