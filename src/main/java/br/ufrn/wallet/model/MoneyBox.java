package br.ufrn.wallet.model;

import br.ufrn.wallet.enums.CurrencyEnum;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MoneyBox")
@EntityListeners(AuditingEntityListener.class)
public class MoneyBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Double value;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency = CurrencyEnum.BRL;

    @ManyToMany
    @JoinTable(name = "money_box_accounts", joinColumns = @JoinColumn(name = "money_box_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
    private List<Account> participants;

    @CreatedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    public Long getId() {
        return id;
    }

    public MoneyBox setId(Long id) {
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

    public List<Account> getParticipants() {
        return participants;
    }

    public MoneyBox setParticipants(List<Account> participants) {
        this.participants = participants;
        return this;
    }

    public MoneyBox addParticipants(Account participant) {
        if (this.participants == null) {
            this.participants = new ArrayList<>();
        }

        this.participants.add(participant);
        return this;
    }

}
