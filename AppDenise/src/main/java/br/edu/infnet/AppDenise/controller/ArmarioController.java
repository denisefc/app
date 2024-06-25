package br.edu.infnet.AppDenise.controller;

import br.edu.infnet.AppDenise.model.domain.Armario;
import br.edu.infnet.AppDenise.model.service.ArmarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ArmarioController {
    @Autowired
    private ArmarioService armarioService;

    @GetMapping(value = "/armario/lista")
    public Collection<Armario> obterLista(){
        return armarioService.obterLista();
    }

    @GetMapping(value = "/armario/listacomordem")
    public Collection<Armario> obterLista(@RequestParam String orderBy){
        return armarioService.obterLista(orderBy);
    }

    @GetMapping(value = "/armario/lista/{puxadores}")
    public Collection<Armario> obterListaComPuxadores(@PathVariable boolean puxadores){
        return armarioService.obterListaComPuxadores(puxadores);
    }

    @GetMapping(value = "/armario/{id}")
    public Armario obterPorId(@PathVariable Integer id) {
        return armarioService.obterPorId(id);
    }

    @PostMapping(value = "/armario/incluir")
    public void incluir(@RequestBody Armario armario) {
        armarioService.incluir(armario);
    }

    @DeleteMapping(value = "/armario/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        armarioService.excluir(id);
    }
}
