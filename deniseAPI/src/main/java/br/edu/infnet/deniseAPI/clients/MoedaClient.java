package br.edu.infnet.deniseAPI.clients;

import br.edu.infnet.deniseAPI.model.domain.Cotacao;
import br.edu.infnet.deniseAPI.model.domain.Moeda;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Collection;

@FeignClient(url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/", name = "moedas")
public interface MoedaClient {
    @GetMapping(value = "/Moedas?%24format=json")
    Collection<Moeda> obterMoedas();
}
