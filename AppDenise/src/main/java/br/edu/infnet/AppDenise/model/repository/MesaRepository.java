package br.edu.infnet.AppDenise.model.repository;

import br.edu.infnet.AppDenise.model.domain.Mesa;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MesaRepository extends CrudRepository<Mesa, Integer> {
    Collection<Mesa> findAll(Sort by);
    Collection<Mesa> findByFormatoContaining(String formato);
}
