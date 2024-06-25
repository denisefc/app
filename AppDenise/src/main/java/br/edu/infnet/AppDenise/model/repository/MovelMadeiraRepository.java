package br.edu.infnet.AppDenise.model.repository;

import br.edu.infnet.AppDenise.model.domain.MovelMadeira;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MovelMadeiraRepository extends CrudRepository<MovelMadeira, Integer> {
    Collection<MovelMadeira> findByPedidoId(Integer id);
    MovelMadeira findByCodigo(int codigo);
}
