package pl.kurs.exchangerateapponspringbootgit.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Profile;
import pl.kurs.exchangerateapponspringbootgit.exceptions.ConnectionProblemException;
import pl.kurs.exchangerateapponspringbootgit.exceptions.InvalidInputDataException;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;

@Profile("era")
//@Service
public class ExchangeRateApiService implements IRateService {

    private IUrlStringBuilder urlStringBuilder;
    private ObjectMapper objectMapper;

    public ExchangeRateApiService(IUrlStringBuilder urlStringBuilder, ObjectMapper objectMapper) {
        this.urlStringBuilder = urlStringBuilder;
        this.objectMapper = objectMapper;
    }

    @Override
    public BigDecimal getRate(String currencyFrom, String currencyTo) throws InvalidInputDataException, ConnectionProblemException {
        String url = urlStringBuilder.buildStringUrl(currencyFrom);

        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(new URL(url));
        } catch (UnknownHostException e) {
            throw new ConnectionProblemException("Błąd połączenia z siecią", e);
        } catch (IOException e) {
            throw new InvalidInputDataException("Przekazano błedną walute wejściową", e);
        }

        JsonNode result = jsonNode.get("conversion_rates");
        JsonNode rate = result.get(currencyTo);

        return new BigDecimal(
                Optional.ofNullable(rate)
                        .orElseThrow(() -> new InvalidInputDataException("Niepoprawna waluta wejściowa."))
                        .asText());
    }
}
