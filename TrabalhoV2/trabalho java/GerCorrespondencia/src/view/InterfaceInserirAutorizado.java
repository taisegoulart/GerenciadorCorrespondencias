package view;

import controle.Comando;
import model.Destinatario;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InterfaceInserirAutorizado extends InterfaceBase implements Comando {
    @Override
    public void executar() {
    //TODO: implementar as ações necessárias para inserir uma pessoa na lista de autorizados do Destinatário


        boolean teste;
        String  pessoaAutorizada= null;
        teste = true;
        do {
            try {
                pessoaAutorizada = leDados("Informe a pessoa autorizada a resseber a encomenda:");
                teste = false;
            } catch (CampoVazioException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() + "  digite um nome!");
            }
        } while (teste);



    }
}
