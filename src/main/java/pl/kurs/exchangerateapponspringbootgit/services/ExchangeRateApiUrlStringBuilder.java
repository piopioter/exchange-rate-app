package pl.kurs.exchangerateapponspringbootgit.services;


import org.springframework.context.annotation.Profile;

import static pl.kurs.exchangerateapponspringbootgit.config.AppConfig.EXCHANGERATEAPI_API_KEY;
import static pl.kurs.exchangerateapponspringbootgit.config.AppConfig.EXCHANGERATEAPI_API_PAGE;

@Profile("era")
//@Service
public class ExchangeRateApiUrlStringBuilder implements IUrlStringBuilder{
    @Override
    public String buildStringUrl(String currencyFrom) {
        return new StringBuffer()
                .append(EXCHANGERATEAPI_API_PAGE)
                .append(EXCHANGERATEAPI_API_KEY)
                .append(currencyFrom)
                .toString();
    }
}
