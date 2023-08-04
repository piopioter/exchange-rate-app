package pl.kurs.exchangerateapponspringbootgit.config;

public interface AppConfig {
    //bc05d9ae4a-182fec4292-ru94ud

    //https://api.fastforex.io/fetch-all?from=USD&api_key=bc05d9ae4a-182fec4292-ru94ud

    String FASTFOREX_API_PAGE = "https://api.fastforex.io";
    String FASTFOREX_ENDPOINT = "/fetch-all?from=";
    String FASTFOREX_API_KEY = "&api_key=99b655130b-3a2cc0448b-ry39j3";

    //"https://v6.exchangerate-api.com/v6/bebcfa0d352b787e052edf5c/latest/USD"


    String EXCHANGERATEAPI_API_PAGE = "https://v6.exchangerate-api.com";
    String EXCHANGERATEAPI_API_KEY = "/v6/bebcfa0d352b787e052edf5c/latest/";


}
