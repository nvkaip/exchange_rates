package com.test_tasks.exchange_rates.controller;

import com.test_tasks.exchange_rates.entity.Currency;
import com.test_tasks.exchange_rates.entity.CurrencyList;
import com.test_tasks.exchange_rates.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class CurrencyController {

    private static final String NBU_EXCHANGE = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange";
    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/update")
    public List<Currency> saveNewExchangeRates() {
        RestTemplate restTemplate = new RestTemplate();
        CurrencyList currencyList =
                restTemplate.getForObject(NBU_EXCHANGE, CurrencyList.class);
        List<Currency> currencies = new ArrayList<>();
        if (currencyList != null) {
            currencies = currencyList.getCurrencyList();
            for (Currency currency : currencies) {
                currencyService.saveCurrency(currency);
                log.info(currency.toString());
            }
        }
        return currencies;
    }
}
