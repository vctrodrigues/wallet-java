package br.ufrn.wallet.model;

import javax.persistence.*;
// import java.util.List;
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
    private Set<Expense> expenses;

    @ManyToMany
    @JoinTable(name = "money_box_accounts", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "money_box_id"))
    private Set<MoneyBox> moneyBoxes;

    public long getId() {
        return id;
    }

    public Account setId(long id) {
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public Account setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }
}
