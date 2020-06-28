import configuration.CommonConfiguration;
import services.HashPasswordService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonConfiguration.class)
@Slf4j
public class HashPasswordServiceTest {
    private HashPasswordService hashPasswordService = new HashPasswordService();

    @Test
    public void hashPasswordTest() {
        System.out.println(hashPasswordService.hashPass("qwerty"));
        System.out.println(hashPasswordService.hashPass("qwerty"));
        System.out.println(hashPasswordService.hashPass("qwerty1"));
        System.out.println(hashPasswordService.hashPass("qwerty1"));
        System.out.println(hashPasswordService.checkPass("1234", "1234"));
        System.out.println(hashPasswordService.checkPass("123", "1234"));
    }
}
