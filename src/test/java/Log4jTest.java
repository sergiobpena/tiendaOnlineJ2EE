import org.junit.Test;
import org.apache.log4j.Logger;
public class Log4jTest {
    static Logger log = Logger.getLogger(Log4jTest.class.getName());
    @Test
    public void rutaLogTest(){
        log.debug("Test");
    }
}
