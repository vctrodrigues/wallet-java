package br.ufrn.wallet.form;

public class TransactionForm {
    private Long accountPayer;
    private Long accountReceiver;
    private String title;
    private String type;
    private String currency;
    private Double value;

    public Long getAccountPayer() {
        return accountPayer;
    }

    public TransactionForm setAccountPayer(Long accountPayer) {
        this.accountPayer = accountPayer;
        return this;
    }

    public Long getAccountReceiver() {
        return accountReceiver;
    }

    public TransactionForm setAccountReceiver(Long accountReceiver) {
        this.accountReceiver = accountReceiver;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TransactionForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    public TransactionForm setType(String type) {
        this.type = type;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public TransactionForm setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public TransactionForm setValue(Double value) {
        this.value = value;
        return this;
    }
}
