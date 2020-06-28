package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.CurrencyRateApiService;

@Configuration
public class CurrencyRateApiConfiguration {

    @Bean
    public CurrencyRateApiService currencyRateApiService(OkHttpClient okHttpClient,
                                                         ObjectMapper objectMapper) {
        return new CurrencyRateApiService(okHttpClient, objectMapper);
    }
}
