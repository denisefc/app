package br.edu.infnet.deniseAPI.clients;

import br.edu.infnet.deniseAPI.model.domain.Moeda;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(url = "https://economia.awesomeapi.com.br/json", name = "cotacao")
public interface MoedaClient {
    @GetMapping(value = "/available/uniq")
    Collection<Moeda> obterMoedas();
}
