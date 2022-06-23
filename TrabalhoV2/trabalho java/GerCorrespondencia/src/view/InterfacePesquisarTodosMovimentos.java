package view;

import controle.Comando;

import javax.swing.*;
import java.util.ArrayList;

public class InterfacePesquisarTodosMovimentos extends InterfaceBase implements Comando {
    @Override
    public void executar() {

        //TODO: implementar as ações necessárias para pesquisar todos os movimentos

        MovimentoDAO dao = new MovimentoDAO();
        List<Movimento> movimentos = dao.pesquisar();
        StringBuilder todasMovimentacoes = new StringBuilder();

        if(movimentos.isEmpty()) {
            todasMovimentacoes.append("Sem movimentação.");
        } else {
            for(Movimento movimento : movimentos) {
                todasMovimentacoes.append(movimento.toString()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, todasMovimentacoes.toString(), " Movimentos", JOptionPane.INFORMATION_MESSAGE);

    }

}
