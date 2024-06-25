package br.edu.infnet.AppDenise.model.service;

import br.edu.infnet.AppDenise.model.domain.Armario;
import br.edu.infnet.AppDenise.model.domain.Mesa;
import br.edu.infnet.AppDenise.model.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    public void incluir(Mesa mesa){
        try {
            mesaRepository.save(mesa);
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }

    public Collection<Mesa> obterLista(){
        return (Collection<Mesa>) mesaRepository.findAll();
    }

    public Collection<Mesa> obterLista(String orderBy){
        return (Collection<Mesa>) mesaRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));
    }
    public Collection<Mesa> obterListaPorFormato(String formato){
        return (Collection<Mesa>) mesaRepository.findByFormatoContaining(formato);
    }

    public Mesa obterPorId(Integer id) {
        return mesaRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        mesaRepository.deleteById(id);
    }

    public long obterQtde() {
        return mesaRepository.count();
    }
}
