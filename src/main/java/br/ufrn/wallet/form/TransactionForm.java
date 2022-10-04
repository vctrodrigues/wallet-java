package br.ufrn.wallet.form;

import br.ufrn.wallet.enums.CurrencyEnum;
import br.ufrn.wallet.enums.TransactionTypeEnum;
import br.ufrn.wallet.model.Account;

public class TransactionForm {
    private String title;
    private TransactionTypeEnum type;
    private CurrencyEnum currency;
    private Double value;
    private Account account;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TransactionTypeEnum getType() {
        return this.type;
    }

    public void setType(TransactionTypeEnum type) {
        this.type = type;
    }

    public CurrencyEnum getCurrency() {
        return this.currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
