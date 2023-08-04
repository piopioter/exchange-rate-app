package pl.kurs.exchangerateapponspringbootgit.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.kurs.exchangerateapponspringbootgit.exceptions.ConnectionProblemException;
import pl.kurs.exchangerateapponspringbootgit.exceptions.InvalidInputDataException;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;

//@Profile("fastforex")
@Service
public class FastForexRateService implements IRateService {

    private ObjectMapper objectMapper;
    private IUrlStringBuilder urlStringBuilder;

    public FastForexRateService(ObjectMapper objectMapper, IUrlStringBuilder urlStringBuilder) {
        this.objectMapper = objectMapper;
        this.urlStringBuilder = urlStringBuilder;
    }

    @Override
    public BigDecimal getRate(String currencyFrom, String currencyTo) throws InvalidInputDataException, ConnectionProblemException {
        String preparedStringUrl = urlStringBuilder.buildStringUrl(currencyFrom);
        JsonNode mainNode;
        
        try {
            mainNode = objectMapper.readTree(new URL(preparedStringUrl));
        } catch (UnknownHostException e) {
            throw new ConnectionProblemException("Błąd połączenia z siecią", e);
        } catch (IOException e) {
            throw new InvalidInputDataException("Przekazano błedną walute wejściową", e);
        }

        JsonNode results = mainNode.get("results");
        JsonNode specificRateNode = results.get(currencyTo);
        return new BigDecimal(
                Optional.ofNullable(specificRateNode).orElseThrow(() -> new InvalidInputDataException("Niepoprawa waluta wyjściowa")
                ).asText()
        );
    }
}
