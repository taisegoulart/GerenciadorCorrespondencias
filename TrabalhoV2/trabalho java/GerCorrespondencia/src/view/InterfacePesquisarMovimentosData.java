package view;

import controle.Comando;
import controle.Processador;
import model.Movimento;
import model.dao.MovimentoDAO;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class InterfacePesquisarMovimentosData extends InterfaceBase implements Comando {
    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para pesquisar todos os movimentos realizados em uma determinada data


        boolean teste = true;
        String dataPesquisada = "";
        do {
            try {
                dataPesquisada = leData();
                teste = false;
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(null, "Data em Formato errado!");
            }
        } while (teste);

        mostraMovimentosPorData(dataPesquisada);


    }

    private String leData() throws ParseException {
        String dataPesquisada = JOptionPane.showInputDialog(null, "Digite a Data: ","dd/mm/aaaa");
        if (dataPesquisada == null) { //trata a saida se usuario pressionar cancela
            Processador.direcionar("0");
            return null;
        }
        new SimpleDateFormat("dd/MM/yyyy").parse(dataPesquisada);
        return dataPesquisada;
    }

    private void mostraMovimentosPorData(String dataPesquisada) {
        MovimentoDAO dao = new MovimentoDAO();
        List<Movimento> movimentos = dao.pesquisaData(dataPesquisada);

        StringBuilder todasMovimentacoes = new StringBuilder();

        if(movimentos.isEmpty()) {
            todasMovimentacoes.append("Não há movimentações registrados para a data: ").append(dataPesquisada);
        } else {
            for(Movimento movimento : movimentos) {
                todasMovimentacoes.append(movimento.toString()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, todasMovimentacoes.toString(), "Todos Movimentos", JOptionPane.INFORMATION_MESSAGE);
    }
    }


