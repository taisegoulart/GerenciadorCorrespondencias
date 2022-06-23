package view;

import controle.Comando;

import javax.swing.*;

public class InterfaceInserirDestinatario extends InterfaceBase implements Comando {
    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para cadastrar um Destinatário
        boolean teste;
        String  Destinatario= null;
        teste = true;
        do {
            try {
                Destinatario = leDados("Informe o nome do Destinatario:");
                teste = false;
            } catch (CampoVazioException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() + "  digite um nome!");
            }
        } while (teste);

    }
}
