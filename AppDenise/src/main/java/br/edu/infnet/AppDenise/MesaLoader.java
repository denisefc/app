package br.edu.infnet.AppDenise;

import br.edu.infnet.AppDenise.model.domain.Mesa;
import br.edu.infnet.AppDenise.model.domain.Pedido;
import br.edu.infnet.AppDenise.model.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(3)
@Component
public class MesaLoader implements ApplicationRunner {
    @Autowired
    private MesaService mesaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("AppDenise/arquivos/mesas.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        System.err.println("#mesas");
        while(linha != null) {

            campos = linha.split(";");

            Mesa mesa = new Mesa();
            mesa.setDescricao(campos[0]);
            mesa.setPreco(Float.valueOf(campos[1]));
            mesa.setCodigo(Integer.valueOf(campos[2]));
            mesa.setDisponivel(Boolean.valueOf(campos[3]));
            mesa.setTipoMadeira(campos[4]);
            mesa.setVidro(Boolean.valueOf(campos[5]));
            mesa.setFormato(campos[6]);

            mesa.setPedido(new Pedido(Integer.valueOf(campos[7])));

            mesaService.incluir(mesa);

            linha = leitura.readLine();
        }

        System.out.println("Iniciando o processamento!");
        for(Mesa mesa : mesaService.obterLista()) {
            System.out.println(mesa);
        }
        System.out.println("Processamento realizado com sucesso!");

        leitura.close();
    }
}
