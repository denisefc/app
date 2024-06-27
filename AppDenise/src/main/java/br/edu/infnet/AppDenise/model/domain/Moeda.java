package br.edu.infnet.AppDenise.model.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Moeda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private String codein;
    private Double bid;

    public Moeda() {
        this.setId(1);
    }

    public Moeda(String code, String codein, Double bid) {
        this();
        this.setCode(code);
        this.setCodein(codein);
        this.setBid(bid);
    }

    @Override
    public String toString() {
        return String.format("%s [%f]", code, bid);
    }
}
