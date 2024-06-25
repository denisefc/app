package br.edu.infnet.AppDenise.controller;

import br.edu.infnet.AppDenise.model.domain.MovelMadeira;
import br.edu.infnet.AppDenise.model.service.MovelMadeiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MovelMadeiraController {
    @Autowired
    private MovelMadeiraService movelMadeiraService;

    @GetMapping(value = "/movelMadeira/lista")
    public Collection<MovelMadeira> obterLista(){
        return movelMadeiraService.obterLista();
    }

    @GetMapping(value = "/movelMadeira/{pedidoId}/lista")
    public Collection<MovelMadeira> obterListaPorPedido(@PathVariable Integer pedidoId){
        return movelMadeiraService.obterListaPorPedido(pedidoId);
    }

    @GetMapping(value =  "/movelMadeira/{codigo}/codigo")
    public MovelMadeira obterPorCodigo(@PathVariable int codigo) {
        return movelMadeiraService.obterPorCodigo(codigo);
    }

    @GetMapping(value = "/movelMadeira/{id}")
    public MovelMadeira obterPorId(@PathVariable Integer id) {
        return movelMadeiraService.obterPorId(id);
    }

    @PostMapping(value = "/movelMadeira/incluir")
    public void incluir(@RequestBody MovelMadeira movelMadeira) {
        movelMadeiraService.incluir(movelMadeira);
    }

    @DeleteMapping(value = "/movelMadeira/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        movelMadeiraService.excluir(id);
    }
}
