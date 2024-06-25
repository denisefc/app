package br.edu.infnet.AppDenise.controller;

import br.edu.infnet.AppDenise.model.domain.Pedido;
import br.edu.infnet.AppDenise.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/pedido/lista")
    public Collection<Pedido> obterLista(){
        return pedidoService.obterLista();
    }

    @GetMapping(value =  "/pedido/{numeroPedido}/numeroPedido")
    public Pedido obterPorNumeroPedido(@PathVariable int numeroPedido) {
        return pedidoService.obterPorNumeroPedido(numeroPedido);
    }

    @GetMapping(value =  "/pedido/{id}")
    public Pedido obterPorId(@PathVariable Integer id) {
        return pedidoService.obterPorId(id);
    }

    @PostMapping(value = "/pedido/incluir")
    public void incluir(@RequestBody Pedido pedido) {
        pedidoService.incluir(pedido);
    }

    @DeleteMapping(value = "/pedido/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        pedidoService.excluir(id);
    }
}
