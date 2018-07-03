import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MyblogApplicationTests.class)
public class MyblogApplicationTests {

    @Test
    public void contextLoads() {
    }

}
