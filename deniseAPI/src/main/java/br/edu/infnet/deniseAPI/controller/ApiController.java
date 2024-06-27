package br.edu.infnet.deniseAPI.controller;

import br.edu.infnet.deniseAPI.model.domain.Endereco;
import br.edu.infnet.deniseAPI.model.domain.Moeda;
import br.edu.infnet.deniseAPI.model.service.EnderecoService;
import br.edu.infnet.deniseAPI.model.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RestController
public class ApiController {

    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private MoedaService moedaService;

    @GetMapping(value = "/{cep}")
    public Endereco obterEnderecoPorCep(@PathVariable String cep) {
        return enderecoService.obterPorCep(cep);
    }

    @GetMapping(value = "/moedas")
    public Collection<Moeda> obterMoedas(){
        return moedaService.obterMoedas();
    }
}
