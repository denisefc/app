package br.edu.infnet.AppDenise.clients;

import br.edu.infnet.AppDenise.model.domain.Endereco;
import br.edu.infnet.AppDenise.model.domain.Cotacao;
import br.edu.infnet.AppDenise.model.domain.Moeda;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "http://localhost:8081", name = "apiDenise")
public interface ApiDeniseClient {
    @GetMapping(value = "/{cep}/cep")
    public Endereco obterEnderecoPorCep(@PathVariable String cep);

    @GetMapping(value = "/{codigo}/cotacao")
    public Collection<Cotacao> obterCotacao(@PathVariable String codigo);

    @GetMapping(value = "/moedas")
    public Collection<Moeda> obterMoedas();

}
