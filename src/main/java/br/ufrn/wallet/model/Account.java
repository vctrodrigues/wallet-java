package br.ufrn.wallet.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "profilePicture")
    private String profilePicture;

    @OneToMany(mappedBy = "account")
    private Set<Transaction> transactions;

    @OneToMany(mappedBy = "account")
    private Set<Expense> expenses;

    @ManyToMany
    @JoinTable(name = "money_box_accounts", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "money_box_id"))
    private Set<MoneyBox> moneyBoxes;

    public Long getId() {
        return id;
    }

    public Account setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public Account setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }
}
