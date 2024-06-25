package br.edu.infnet.AppDenise.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "TArmario")
public class Armario extends MovelMadeira{
    @Column(name = "flpuxadores")
    private boolean puxadores;

    @Min(value = 0, message = "A quantidade de gavetas precisa ser maior ou igual a {min}.")
    @Max(value = 10, message = "A quantidade de gavetas precisa ser menor ou igual a {max}.")
    @Column(name = "qtgavetas")
    private int quantidadeGavetas;

    @Override
    public String toString() {
        return String.format("%s - %s - %d gavetas",
                super.toString(),
                puxadores ? "puxadores=S" : "puxadores=N",
                quantidadeGavetas
        );
    }

}
