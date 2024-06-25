package br.edu.infnet.deniseAPI.model.service;

import br.edu.infnet.deniseAPI.clients.EnderecoClient;
import br.edu.infnet.deniseAPI.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoClient enderecoClient;

    public Endereco obterPorCep(String cep) {
        return enderecoClient.obterPorCep(cep);
    }
}
