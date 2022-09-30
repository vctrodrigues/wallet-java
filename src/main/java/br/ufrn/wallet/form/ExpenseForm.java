package br.ufrn.wallet.form;

import br.ufrn.wallet.enums.CurrencyEnum;
import br.ufrn.wallet.model.Account;

public class ExpenseForm {

  private String description;
  private Double value;
  private CurrencyEnum currency;
  private int day;
  private Account account;

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getValue() {
    return this.value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public CurrencyEnum getCurrency() {
    return this.currency;
  }

  public void setCurrency(CurrencyEnum currency) {
    this.currency = currency;
  }

  public int getDay() {
    return this.day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public Account getAccount() {
    return this.account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

}