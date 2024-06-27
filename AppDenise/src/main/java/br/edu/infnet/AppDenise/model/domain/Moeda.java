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
    private String name;

    public Moeda() {
        this.setId(1);
    }

    public Moeda(String code, String name) {
        this();
        this.setCode(code);
        this.setName(name);
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", name, code);
    }
}