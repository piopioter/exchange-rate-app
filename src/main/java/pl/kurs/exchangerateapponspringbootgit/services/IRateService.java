package pl.kurs.exchangerateapponspringbootgit.services;

import pl.kurs.exchangerateapponspringbootgit.exceptions.ConnectionProblemException;
import pl.kurs.exchangerateapponspringbootgit.exceptions.InvalidInputDataException;

import java.math.BigDecimal;

public interface IRateService {

    BigDecimal getRate(String currencyFrom, String currencyTo) throws InvalidInputDataException, ConnectionProblemException;
}
