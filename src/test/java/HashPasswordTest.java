import configuration.CommonConfiguration;
import core.HashPassword;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonConfiguration.class)
@Slf4j
public class HashPasswordTest {
    private HashPassword hashPassword;

    @PostConstruct
    public void init() { hashPassword = new HashPassword(); }

    @Test
    public void hashPasswordTest() {
        System.out.println(hashPassword.hashPass("qwerty"));
        System.out.println(hashPassword.hashPass("qwerty"));
        System.out.println(hashPassword.hashPass("qwerty1"));
        System.out.println(hashPassword.hashPass("qwerty1"));
    }
}
