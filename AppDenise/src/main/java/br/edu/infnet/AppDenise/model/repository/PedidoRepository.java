package br.edu.infnet.AppDenise.model.repository;

import br.edu.infnet.AppDenise.model.domain.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
    Pedido findByNumeroPedido(int numeroPedido);
}
