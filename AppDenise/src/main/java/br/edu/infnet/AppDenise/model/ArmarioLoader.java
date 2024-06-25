package br.edu.infnet.AppDenise.model;

import br.edu.infnet.AppDenise.model.domain.Armario;
import br.edu.infnet.AppDenise.model.domain.Pedido;
import br.edu.infnet.AppDenise.model.service.ArmarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(2)
@Component
public class ArmarioLoader implements ApplicationRunner{
    @Autowired
    private ArmarioService armarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("AppDenise/arquivos/armarios.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        System.err.println("#armarios");
        while(linha != null) {

            campos = linha.split(";");

            Armario armario = new Armario();
            armario.setDescricao(campos[0]);
            armario.setPreco(Float.valueOf(campos[1]));
            armario.setCodigo(Integer.valueOf(campos[2]));
            armario.setDisponivel(Boolean.valueOf(campos[3]));
            armario.setTipoMadeira(campos[4]);
            armario.setPuxadores(Boolean.valueOf(campos[5]));
            armario.setQuantidadeGavetas(Integer.valueOf(campos[6]));

            armario.setPedido(new Pedido(Integer.valueOf(campos[7])));

            armarioService.incluir(armario);

            linha = leitura.readLine();
        }

        System.out.println("Iniciando o processamento!");
        for(Armario armario : armarioService.obterLista()) {
            System.out.println(armario);
        }
        System.out.println("Processamento realizado com sucesso!");

        leitura.close();
    }
}
