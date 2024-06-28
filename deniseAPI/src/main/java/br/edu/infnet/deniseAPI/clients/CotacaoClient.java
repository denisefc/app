package br.edu.infnet.deniseAPI.clients;

import br.edu.infnet.deniseAPI.model.domain.Cotacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "https://economia.awesomeapi.com.br/json", name = "cotacao")
public interface CotacaoClient {
    @GetMapping(value = "/{codigo}-BRL")
    Collection<Cotacao> obterCotacao(@PathVariable String codigo);
}
