package br.ufrn.wallet.form;

public class PaymentForm {
    private String code;
    private Double value;
    private String description;

    public String getCode() {
        return code;
    }

    public PaymentForm setCode(String code) {
        this.code = code;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public PaymentForm setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PaymentForm setDescription(String description) {
        this.description = description;
        return this;
    }
}
