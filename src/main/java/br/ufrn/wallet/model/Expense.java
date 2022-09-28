package br.ufrn.wallet.model;

import br.ufrn.wallet.enums.CurrencyEnum;

public class Expense {
    private long id;
    private String description;
    private Double value;
    private CurrencyEnum currency;
    private int day;

    public long getId() {
        return id;
    }

    public Expense setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Expense setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Expense setValue(Double value) {
        this.value = value;
        return this;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public Expense setCurrency(CurrencyEnum currency) {
        this.currency = currency;
        return this;
    }

    public int getDay() {
        return day;
    }

    public Expense setDay(int day) {
        this.day = day;
        return this;
    }
}
