package br.edu.infnet.AppDenise.model.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String high;

    public Cotacao() {
        this.setId(1);
    }

    public Cotacao(String code, String name, String high) {
        this();
        this.setCode(code);
        this.setName(name);
        this.setHigh(high);
    }

    @Override
    public String toString() {
        return String.format("%s - [R$ %s]", code, high);
    }
}