import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.CommonConfiguration;
import configuration.CurrencyRateApiConfiguration;
import services.CurrencyRateApiService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommonConfiguration.class, CurrencyRateApiConfiguration.class})
@Slf4j
public class CurrencyRateApiTest {

    @Autowired
    private CurrencyRateApiService currencyRateApiService;

    @Test
    public void getEurRub() {
        System.out.println(currencyRateApiService.getEurRub());
    }

    @Test
    public void getUsdRub() {
        System.out.println(currencyRateApiService.getUsdRub());
    }

    @Test
    public void getRate() {
        System.out.println(currencyRateApiService.getRate("USDRUB"));
    }
}
