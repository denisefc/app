package br.edu.infnet.AppDenise.model.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonAlias(value = "simbolo")
    private String simbolo;
    @JsonAlias(value = "nomeFormatado")
    private String nomeFormatado;

    public Value() {
        this.setId(1);
    }

    public Value(String simbolo, String nomeFormatado) {
        this();
        this.setSimbolo(simbolo);
        this.setNomeFormatado(nomeFormatado);
    }

    @Override
    public String toString() {
        return String.format("%s - [%s]", nomeFormatado, simbolo);
    }
}
