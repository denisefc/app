package br.edu.infnet.AppDenise.controller;

import br.edu.infnet.AppDenise.model.domain.Mesa;
import br.edu.infnet.AppDenise.model.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MesaController {
    @Autowired
    private MesaService mesaService;

    @GetMapping(value = "/mesa/lista")
    public Collection<Mesa> obterLista(){
        return mesaService.obterLista();
    }

    @GetMapping(value = "/mesa/listacomordem")
    public Collection<Mesa> obterLista(@RequestParam String orderBy){
        return mesaService.obterLista(orderBy);
    }

    @GetMapping(value = "/mesa/lista/{formato}")
    public Collection<Mesa> obterListaPorFormato(@PathVariable String formato){
        return mesaService.obterListaPorFormato(formato);
    }

    @GetMapping(value =  "/mesa/{id}")
    public Mesa obterPorId(@PathVariable Integer id) {
        return mesaService.obterPorId(id);
    }

    @PostMapping(value = "/mesa/incluir")
    public void incluir(@RequestBody Mesa mesa) {
        mesaService.incluir(mesa);
    }

    @DeleteMapping(value = "/mesa/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        mesaService.excluir(id);
    }
}
