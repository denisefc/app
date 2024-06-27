package br.edu.infnet.deniseAPI.model.service;

import br.edu.infnet.deniseAPI.clients.MoedaClient;
import br.edu.infnet.deniseAPI.model.domain.Moeda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MoedaService {
    @Autowired
    private MoedaClient moedaClient;

    public Collection<Moeda> obterMoedas(){
        return moedaClient.obterMoedas();
    }
}
