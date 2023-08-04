package pl.kurs.exchangerateapponspringbootgit.services;

import pl.kurs.exchangerateapponspringbootgit.exceptions.ConnectionProblemException;
import pl.kurs.exchangerateapponspringbootgit.exceptions.InvalidInputDataException;

import java.math.BigDecimal;

public interface ICurrencyService {

    BigDecimal exchange(String from, String to, BigDecimal amount) throws InvalidInputDataException, ConnectionProblemException;


}
