package br.edu.infnet.AppDenise.model.service;

import br.edu.infnet.AppDenise.model.domain.Armario;
import br.edu.infnet.AppDenise.model.repository.ArmarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArmarioService {
    @Autowired
    private ArmarioRepository armarioRepository;

    public void incluir(Armario armario){
        try {
            armarioRepository.save(armario);
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }

    public Collection<Armario> obterLista(){
        return (Collection<Armario>) armarioRepository.findAll();
    }

    public Collection<Armario> obterLista(String orderBy){
        return (Collection<Armario>) armarioRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));
    }

    public Collection<Armario> obterListaComPuxadores(boolean puxadores) {
        return (Collection<Armario>) armarioRepository.findByPuxadores(puxadores);
    }

    public Armario obterPorId(Integer id) {
        return armarioRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        armarioRepository.deleteById(id);
    }

    public long obterQtde() {
        return armarioRepository.count();
    }
}
