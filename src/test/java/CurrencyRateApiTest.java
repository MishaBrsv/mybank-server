import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.CommonConfiguration;
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
@SpringBootTest(classes = CommonConfiguration.class)
@Slf4j
public class CurrencyRateApiTest {
    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private ObjectMapper objectMapper;

    private CurrencyRateApiService currencyRateApiService;

    @PostConstruct
    public void init() { currencyRateApiService = new CurrencyRateApiService(okHttpClient, objectMapper); }

    @Test
    public void getEurRub() {
        System.out.println(currencyRateApiService.getEurRub());
    }

    @Test
    public void getUsdRub() {
        System.out.println(currencyRateApiService.getUsdRub());
    }
}
