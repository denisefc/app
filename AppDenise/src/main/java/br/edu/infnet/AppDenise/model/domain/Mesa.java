package br.edu.infnet.AppDenise.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "TMesa")
public class Mesa extends MovelMadeira{
    @Column(name = "flvidro")
    private boolean vidro;

    @NotBlank(message = "É necessário preencher o campo FORMATO!")
    @Column(name="dsformato")
    private String formato;

    @Override
    public String toString() {
        return String.format("%s - %s - %s",
                super.toString(),
                vidro ? "vidro=S" : "vidro=N",
                formato
        );
    }
}
