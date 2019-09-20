package com.test_tasks.exchange_rates.service.impl;

import com.test_tasks.exchange_rates.entity.Currency;
import com.test_tasks.exchange_rates.repository.CurrencyRepository;
import com.test_tasks.exchange_rates.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public void saveCurrency(Currency currency) {
        currencyRepository.save(currency);
    }
}
