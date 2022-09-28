package br.ufrn.wallet.model;

import br.ufrn.wallet.enums.CurrencyEnum;

import java.util.List;

public class MoneyBox {
    private long id;
    private String name;
    private String description;
    private Double value;
    private CurrencyEnum currency;
    private List<User> participants;

    public long getId() {
        return id;
    }

    public MoneyBox setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MoneyBox setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MoneyBox setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public MoneyBox setValue(Double value) {
        this.value = value;
        return this;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public MoneyBox setCurrency(CurrencyEnum currency) {
        this.currency = currency;
        return this;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public MoneyBox setParticipants(List<User> participants) {
        this.participants = participants;
        return this;
    }
}
