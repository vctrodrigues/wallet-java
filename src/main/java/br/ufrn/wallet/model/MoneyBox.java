package br.ufrn.wallet.model;

import br.ufrn.wallet.enums.CurrencyEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MoneyBox")
public class MoneyBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private Double value;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    @ManyToMany(mappedBy = "moneyBoxes")
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
