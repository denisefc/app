package br.edu.infnet.AppDenise.model.repository;

import br.edu.infnet.AppDenise.model.domain.Armario;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ArmarioRepository extends CrudRepository<Armario, Integer> {
    Collection<Armario> findAll(Sort by);
    Collection<Armario> findByPuxadores(boolean puxadores);
}
