package br.edu.infnet.deniseAPI.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Moeda {
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
