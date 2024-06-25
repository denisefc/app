package br.edu.infnet.deniseAPI.controller;

import br.edu.infnet.deniseAPI.model.domain.Endereco;
import br.edu.infnet.deniseAPI.model.service.EnderecoService;
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

    @GetMapping(value = "/listagem")
    public Collection<String> obterLista(){
        return new ArrayList<String>(
                Arrays.asList("Denise", "Frimer", "Czapnik")
        );
    }

    @GetMapping(value = "/{cep}")
    public Endereco obterEnderecoPorCep(@PathVariable String cep) {
        return enderecoService.obterPorCep(cep);
    }

}
