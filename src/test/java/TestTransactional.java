import org.example.AuroraSpringbootApplication;
import org.example.controller.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author RainZiYu
 * @Date 2023/4/14
 */
@SpringBootTest(classes = AuroraSpringbootApplication.class)
public class TestTransactional {
    @Autowired
    private TestController testController;
    @Test
    public void test(){
        testController.testTransactional();
    }
}
