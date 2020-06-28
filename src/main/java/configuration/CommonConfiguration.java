package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
public class CommonConfiguration {

    @Bean
    public ObjectMapper objectMapper() {return new ObjectMapper();}

    @Bean
    public OkHttpClient httpClient() { return new OkHttpClient(); }

}
