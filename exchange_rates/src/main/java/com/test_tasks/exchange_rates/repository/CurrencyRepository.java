package com.test_tasks.exchange_rates.repository;

import com.test_tasks.exchange_rates.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}
