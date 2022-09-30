package br.ufrn.wallet.model;

import br.ufrn.wallet.enums.CurrencyEnum;
import br.ufrn.wallet.enums.TransactionTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "accountPayer")
    private Account accountPayer;

    @OneToOne
    @JoinColumn(name = "accountReceiver")
    private Account accountReceiver;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    @Column(name = "value")
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
