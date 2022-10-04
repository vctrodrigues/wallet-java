package br.ufrn.wallet.model;

import br.ufrn.wallet.enums.CurrencyEnum;

import javax.persistence.*;

@Entity
@Table(name = "Expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private Double value;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency = CurrencyEnum.BRL;

    @Column(name = "day")
    private int day;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Long getId() {
        return id;
    }

    public Expense setId(Long id) {
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

    public Account getAccount() {
        return this.account;
    }

    public Expense setAccount(Account account) {
        this.account = account;
        return this;
    }
}
