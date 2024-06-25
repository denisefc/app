package br.edu.infnet.AppDenise.model.service;

import br.edu.infnet.AppDenise.model.domain.Armario;
import br.edu.infnet.AppDenise.model.domain.MovelMadeira;
import br.edu.infnet.AppDenise.model.repository.MovelMadeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovelMadeiraService {
    @Autowired
    private MovelMadeiraRepository movelMadeiraRepository;

    public void incluir(MovelMadeira movelMadeira){
        try {
            movelMadeiraRepository.save(movelMadeira);
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }

    public Collection<MovelMadeira> obterLista(){
        return (Collection<MovelMadeira>) movelMadeiraRepository.findAll();
    }

    public Collection<MovelMadeira> obterListaPorPedido(Integer id){
        return (Collection<MovelMadeira>) movelMadeiraRepository.findByPedidoId(id);
    }

    public MovelMadeira obterPorCodigo(int codigo){
        return movelMadeiraRepository.findByCodigo(codigo);
    }

    public MovelMadeira obterPorId(Integer id) {
        return movelMadeiraRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        movelMadeiraRepository.deleteById(id);
    }

    public long obterQtde() {
        return movelMadeiraRepository.count();
    }
}
