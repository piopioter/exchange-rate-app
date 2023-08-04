package pl.kurs.exchangerateapponspringbootgit.services;

import org.springframework.stereotype.Service;
import pl.kurs.exchangerateapponspringbootgit.exceptions.ConnectionProblemException;
import pl.kurs.exchangerateapponspringbootgit.exceptions.InvalidInputDataException;


import java.math.BigDecimal;

@Service
public class CurrencyService implements ICurrencyService {

    private IRateService rateService;



    public CurrencyService(IRateService rateService) {
        this.rateService = rateService;

    }

    @Override
    public BigDecimal exchange(String from, String to, BigDecimal amount) throws InvalidInputDataException, ConnectionProblemException {
        if (from == null)
            throw new InvalidInputDataException("Waluta wejściowa jest nullem");
        if (to == null)
            throw new InvalidInputDataException("Waluta wyjściowa jest nullem");
        if (amount.doubleValue() <= 0)
            throw new InvalidInputDataException("Wartości powinna być wyZej zera");

        BigDecimal rate = rateService.getRate(from, to);


        BigDecimal exchangeResult = rate.multiply(amount);





        return exchangeResult;
    }




}
