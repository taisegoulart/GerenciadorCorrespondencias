package model.dao;
import model.Correspondencia;
import model.Destinatario;

import java.util.ArrayList;
import java.util.List;
//acho que tá pronto
public class CorrespondenciaDAO implements OperacoesDAO<Correspondencia>{
    private ArrayList<Correspondencia> listaCorrespondencias = new ArrayList<Correspondencia>();

 //   public ArrayList<Correspondencia> getCorrespondencias() {
  //      return listaCorrespondencias; ------->tirei dia 21
  //  } //modifiquei dia 19/06

    @Override
    public boolean inserir(Correspondencia obj) {
    // getCorrespondencias().add(obj);
        listaCorrespondencias.add(obj);

        return false;
    }

    @Override
    public void excluir(Correspondencia obj) {
        listaCorrespondencias.remove(obj);
    }

    @Override
    public void editar(Correspondencia newObj) {
        //as funcionalidades requeridas para implementação não necessitam de uma função editar
        //fazer?
    }

    @Override
    public List<Correspondencia> pesquisar() {
//return listaCorrespondencias; (por que não?)
        return null;
    }

 //modificar os a seguir (feito?):
    public List<Correspondencia> pesquisarNaoRetiradas(Destinatario destinatario) {
        List<Correspondencia> correspondenciasNaoRetiradas = new ArrayList<>();
        for(Correspondencia correspondencia : listaCorrespondencias) {
            boolean pertenceDestinatario = correspondencia.getDestino().equals(destinatario);
            if(pertenceDestinatario && !correspondencia.getStatus()) {
                correspondenciasNaoRetiradas.add(correspondencia);
            }
        }
        return correspondenciasNaoRetiradas;


    }
}
