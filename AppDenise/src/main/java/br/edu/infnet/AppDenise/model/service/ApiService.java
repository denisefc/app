package br.edu.infnet.AppDenise.model.service;

import br.edu.infnet.AppDenise.model.domain.Endereco;
import br.edu.infnet.AppDenise.model.domain.Moeda;
import br.edu.infnet.AppDenise.model.repository.EnderecoRepository;
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

    public Collection<Moeda> obterMoedas() {
        return (Collection<Moeda>) apiDeniseClient.obterMoedas();
    }
}
