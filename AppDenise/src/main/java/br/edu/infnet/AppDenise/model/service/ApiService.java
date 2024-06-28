package br.edu.infnet.AppDenise.model.service;

import br.edu.infnet.AppDenise.model.domain.Endereco;
import br.edu.infnet.AppDenise.model.domain.Cotacao;
import br.edu.infnet.AppDenise.model.domain.Moeda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.AppDenise.clients.ApiDeniseClient;

import java.util.Collection;

@Service
public class ApiService {
    @Autowired
    private ApiDeniseClient apiDeniseClient;

    public Endereco obterPorCep(String cep) {
        return apiDeniseClient.obterEnderecoPorCep(cep);
    }

    public Collection<Cotacao> obterCotacao(String codigo) {
        return apiDeniseClient.obterCotacao(codigo);
    }

    public Collection<Moeda> obterMoedas() {
        return apiDeniseClient.obterMoedas();
    }

}
