package pl.kurs.exchangerateapponspringbootgit.services;

import org.springframework.stereotype.Service;

import static pl.kurs.exchangerateapponspringbootgit.config.AppConfig.*;

//@Profile("fastforex")
@Service
public class FastForexUrlStringBuilder implements IUrlStringBuilder{

    @Override
    public String buildStringUrl(String currencyFrom) {
        return new StringBuffer()
                .append(FASTFOREX_API_PAGE)
                .append(FASTFOREX_ENDPOINT)
                .append(currencyFrom)
                .append(FASTFOREX_API_KEY)
                .toString();
    }
}
