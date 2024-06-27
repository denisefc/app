package br.edu.infnet.AppDenise.model;

import br.edu.infnet.AppDenise.model.domain.Armario;
import br.edu.infnet.AppDenise.model.domain.Endereco;
import br.edu.infnet.AppDenise.model.domain.Mesa;
import br.edu.infnet.AppDenise.model.domain.Pedido;
import br.edu.infnet.AppDenise.model.service.ArmarioService;
import br.edu.infnet.AppDenise.model.service.ApiService;
import br.edu.infnet.AppDenise.model.service.MesaService;
import br.edu.infnet.AppDenise.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

@Order(1)
@Component
public class PedidoLoader implements ApplicationRunner {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ArmarioService armarioService;
    @Autowired
    private MesaService mesaService;
    @Autowired
    private ApiService apiService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("AppDenise/arquivos/pedidos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        Pedido pedido = null;

        System.err.println("#pedidos");
        while(linha != null) {

            campos = linha.split(";");

            switch (campos[0].toUpperCase()) {
                case "P":
                    Endereco endereco = apiService.obterPorCep(campos[3]);

                    pedido = new Pedido();
                    pedido.setNumeroPedido(Integer.valueOf(campos[1]));
                    pedido.setTotalReais(Float.valueOf(campos[2]));
                    pedido.setEndereco(endereco);

                    pedidoService.incluir(pedido);
                    break;

                case "A":
                    Armario armario = new Armario();
                    armario.setDescricao(campos[1]);
                    armario.setPreco(Float.valueOf(campos[2]));
                    armario.setCodigo(Integer.valueOf(campos[3]));
                    armario.setDisponivel(Boolean.valueOf(campos[4]));
                    armario.setTipoMadeira(campos[5]);
                    armario.setPuxadores(Boolean.valueOf(campos[6]));
                    armario.setQuantidadeGavetas(Integer.valueOf(campos[7]));

                    armario.setPedido(pedido);

                    armarioService.incluir(armario);

                    pedido.getMoveisMadeira().add(armario);
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

                    mesa.setPedido(pedido);

                    mesaService.incluir(mesa);

                    pedido.getMoveisMadeira().add(mesa);
                    break;

                default:
                    System.err.println("Linha: " + Arrays.asList(campos));
                    break;
            }


            linha = leitura.readLine();
        }

        System.out.println("Iniciando o processamento!");
        for(Pedido oPedido : pedidoService.obterLista()) {
            System.out.println(oPedido);
        }
        System.out.println("Processamento realizado com sucesso!");

        leitura.close();
    }
    
}
