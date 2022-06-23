package view;

import controle.Comando;
import controle.Processador;
import model.*;
import model.dao.CorrespondenciaDAO;
import model.dao.DestinatarioDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterfacePesquisarCorrespondencia extends InterfaceBase implements Comando{

    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para pesquisar se existem correspondências não entregues para um determinado destinatário, identificando se são cartas ou pacotes
        String nome;
        boolean teste = true;
        Destinatario destinatario = null;

        do {
            try {
                nome = leDados("Informe o nome completo do destinatário a ser pesquisado");
                destinatario = pesquisaDestinatario(nome);
                if (destinatario != null) {teste = false;}
            } catch (CampoVazioException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " novamente");
            }
        } while (teste);


        informaCorrespondenciasNaoRetiradas(destinatario);
    }

    private void informaCorrespondenciasNaoRetiradas(Destinatario destinatario) {
        CorrespondenciaDAO correspondenciaDAO = new CorrespondenciaDAO();

        if(destinatario != null) {
            List<Correspondencia> naoRetiradas = correspondenciaDAO.pesquisarNaoRetiradas(destinatario);
            JOptionPane.showMessageDialog(null, pegaStringCorrespondencias(naoRetiradas));
        }
    }

    //constroi string para saida
    private String pegaStringCorrespondencias(List<Correspondencia> naoRetiradas) {
        StringBuilder correspondencias = new StringBuilder();

        if(naoRetiradas.isEmpty()) {
            correspondencias.append("Esse destinatario nao possui correspondencia a ser retirada.");
            return correspondencias.toString();
        }

        for(Correspondencia correspondencia : naoRetiradas) {

            if(correspondencia instanceof Carta carta) {
                correspondencias.append("\n").append(carta).append("\n");
            } else if (correspondencia instanceof Pacote pacote) {
                correspondencias.append("\n").append(pacote).append("\n");
            }

        }
        return correspondencias.toString();
    }

   // private Destinatario pesquisaDestinatario(String nome) {
    //    DestinatarioDAO dao = new DestinatarioDAO();
    //    try {
     //       return dao.pesquisaDestinatario(nome);
     //   } catch (DestinatarioInexistenteException e) {
     //       JOptionPane.showMessageDialog(null, e.getMessage());
     //       return null;
     //   }
   // }

    public static String leDados(String mensagem) throws CampoVazioException {
        String opcao = JOptionPane.showInputDialog(null, mensagem);
        if (opcao == null) { //trata a saida se usuario pressionar cancela
            Processador.direcionar("0");
            return null;
        }
        opcao = opcao.replaceAll("\\s{2,}", " ").trim();
        if (opcao.length() == 0) {
            throw new CampoVazioException(mensagem);
        } else {
            return opcao;
        }
    }

}
