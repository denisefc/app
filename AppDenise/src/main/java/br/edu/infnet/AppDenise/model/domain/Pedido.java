package br.edu.infnet.AppDenise.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@Table(name = "TPedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "csnumeroPedido")
    @Min(value = 1, message = "O numero do pedido precisa ser maior ou igual a {value}")
    private int numeroPedido;

    @Column(name = "vltotalReais")
    @Min(value = 1, message = "O valor total em reais do pedido precisa ser maior ou igual a {value}")
    private float totalReais;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idPedido")
    @JsonManagedReference
    private List<MovelMadeira> moveisMadeira;

    @OneToOne
    private Endereco endereco;

    public Pedido() {
        this.moveisMadeira = new ArrayList<MovelMadeira>();
    }

    public Pedido(Integer id) {
        this();
        this.setId(id);
    }

    @Override
    public String toString() {
        return String.format("%d - %.2f - %d - Endereço: %s",
                numeroPedido,
                totalReais,
                moveisMadeira.size(),
                endereco
        );
    }
}
