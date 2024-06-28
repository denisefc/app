package br.edu.infnet.deniseAPI.model.service;

import br.edu.infnet.deniseAPI.clients.CotacaoClient;
import br.edu.infnet.deniseAPI.model.domain.Cotacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CotacaoService {
    @Autowired
    private CotacaoClient cotacaoClient;

    public Collection<Cotacao> obterCotacao(String codigo){
        return cotacaoClient.obterCotacao(codigo);
    }
}
