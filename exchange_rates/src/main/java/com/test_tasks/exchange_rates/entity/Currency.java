package com.test_tasks.exchange_rates.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@XmlRootElement(name="currency")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @XmlElement
    @Column(name = "r030")
    private Integer r030;

    @NonNull
    @XmlElement(name = "txt")
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "rate")
    private Double rate;

    @NonNull
    @Column(name = "cc")
    private String cc;

    @NonNull
    @XmlElement(name = "exchangedate")
    @Column(name = "exchange_date")
    private String exchangeDate;
}
