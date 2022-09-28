package br.ufrn.wallet.model;

import br.ufrn.wallet.enums.CurrencyEnum;
import br.ufrn.wallet.enums.TransactionTypeEnum;

public class Transaction {
    private long id;
    private User userPayer;
    private User userReceiver;
    private String title;
    private TransactionTypeEnum type;
    private CurrencyEnum currency;
    private Double value;

    public long getId() {
        return id;
    }

    public Transaction setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Transaction setTitle(String title) {
        this.title = title;
        return this;
    }

    public TransactionTypeEnum getType() {
        return type;
    }

    public Transaction setType(TransactionTypeEnum type) {
        this.type = type;
        return this;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public Transaction setCurrency(CurrencyEnum currency) {
        this.currency = currency;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Transaction setValue(Double value) {
        this.value = value;
        return this;
    }
}
