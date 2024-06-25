package br.edu.infnet.AppDenise.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "TMovelMadeira")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MovelMadeira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 200, message = "A descricao do movel deve ter entre {min} e {max} caracteres.")
    @Column(name="dsdescricao")
    private String descricao;

    @Min(value = 1, message = "O codigo deve ser maior ou igual a {value}.")
    @Column(unique = true, name = "cscodigo")
    private int codigo;

    @Column(name = "vlpreco")
    @Min(value = 1, message = "O preço do movel precisa ser maior ou igual a {value}")
    private float preco;

    @Column(name = "fldisponivel")
    private boolean disponivel;

    @Size(min = 3, max = 25, message = "O tipo de madeira do movel deve ter entre {min} e {max} caracteres.")
    @Column(name="dstipoMadeira")
    private String tipoMadeira;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    @JsonBackReference
    private Pedido pedido;

    @Override
    public String toString() {
        return String.format("%d - %s - %.2f - %d - %s - %s",
                id,
                descricao,
                preco,
                codigo,
                disponivel ? "disponivel=S" : "disponivel=N",
                tipoMadeira
        );
    }
}
