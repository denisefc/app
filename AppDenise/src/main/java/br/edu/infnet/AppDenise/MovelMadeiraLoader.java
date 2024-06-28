package br.edu.infnet.AppDenise;

import br.edu.infnet.AppDenise.model.domain.Armario;
import br.edu.infnet.AppDenise.model.domain.Mesa;
import br.edu.infnet.AppDenise.model.domain.MovelMadeira;
import br.edu.infnet.AppDenise.model.domain.Pedido;
import br.edu.infnet.AppDenise.model.service.MovelMadeiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(4)
@Component
public class MovelMadeiraLoader implements ApplicationRunner {
    @Autowired
    private MovelMadeiraService movelMadeiraService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("AppDenise/arquivos/moveismadeira.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        System.err.println("#moveisMadeira");
        while(linha != null) {

            campos = linha.split(";");

            switch (campos[0].toUpperCase()) {
                case "A":
                    Armario armario = new Armario();
                    armario.setDescricao(campos[1]);
                    armario.setPreco(Float.valueOf(campos[2]));
                    armario.setCodigo(Integer.valueOf(campos[3]));
                    armario.setDisponivel(Boolean.valueOf(campos[4]));
                    armario.setTipoMadeira(campos[5]);
                    armario.setPuxadores(Boolean.valueOf(campos[6]));
                    armario.setQuantidadeGavetas(Integer.valueOf(campos[7]));

                    armario.setPedido(new Pedido(Integer.valueOf(campos[8])));

                    movelMadeiraService.incluir(armario);
                    break;

                case "M":
                    Mesa mesa = new Mesa();
                    mesa.setDescricao(campos[1]);
                    mesa.setPreco(Float.valueOf(campos[2]));
                    mesa.setCodigo(Integer.valueOf(campos[3]));
                    mesa.setDisponivel(Boolean.valueOf(campos[4]));
                    mesa.setTipoMadeira(campos[5]);
                    mesa.setVidro(Boolean.valueOf(campos[6]));
                    mesa.setFormato(campos[7]);

                    mesa.setPedido(new Pedido(Integer.valueOf(campos[8])));

                    movelMadeiraService.incluir(mesa);
                    break;

                default:
                    System.err.println("Tipo inválido!!!");
            }

            linha = leitura.readLine();
        }

        System.out.println("Iniciando o processamento!");
        for(MovelMadeira movelMadeira : movelMadeiraService.obterLista()) {
            System.out.println(movelMadeira);
        }
        System.out.println("Processamento realizado com sucesso!");

        leitura.close();
    }
}
