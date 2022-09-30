package br.ufrn.wallet.model;

import javax.persistence.*;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private Double value;

    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public Payment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Payment setCode(String code) {
        this.code = code;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Payment setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Payment setDescription(String description) {
        this.description = description;
        return this;
    }
}
