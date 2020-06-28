package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyRateApiService {
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    /**
     * Метод возвращает нужный нам курс валюты
     * @param direction - направление в курсе. Например: "USDRUB", "EURRUB"
     * @return - возвращение курса на данный момент
     */
    public String getRate(String direction) {
        String apiUrl = "https://www.freeforexapi.com/api/live?pairs=";
        String url = apiUrl + direction;
        Request request = new Request.Builder().url(url).build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            String responseString = Objects.requireNonNull(response.body()).string();
            JsonNode jsonNode = objectMapper.readTree(responseString);

            JsonNode result = !jsonNode.get("rates").isNull() ?
                    jsonNode.get("rates").get(direction).get("rate") : null;

            return Objects.nonNull(result) ? objectMapper.readValue(result.toString(), String.class) :
                    "-1";
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    public Double getEurRub() {
        return Double.parseDouble(getRate("EURUSD")) * Double.parseDouble(getRate("USDRUB"));
    }

    public Double getUsdRub() {
        return Double.parseDouble(getRate("USDRUB"));
    }
}
