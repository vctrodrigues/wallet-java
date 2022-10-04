package br.ufrn.wallet.model;

import br.ufrn.wallet.enums.CurrencyEnum;
import br.ufrn.wallet.enums.TransactionTypeEnum;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Transaction")
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

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

    @CreatedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    public Long getId() {
        return id;
    }

    public Transaction setId(Long id) {
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

    public Account getAccount() {
        return this.account;
    }

    public Transaction setAccount(Account account) {
        this.account = account;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
