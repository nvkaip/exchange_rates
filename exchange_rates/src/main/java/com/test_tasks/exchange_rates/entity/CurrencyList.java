package com.test_tasks.exchange_rates.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement(name="exchange")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyList {

    @XmlElement(name = "currency")
    private List<Currency> currencyList;

    public CurrencyList() {
        this.currencyList = new ArrayList<>();
    }
}
