package br.edu.infnet.AppDenise.model.repository;

import br.edu.infnet.AppDenise.model.domain.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

}
