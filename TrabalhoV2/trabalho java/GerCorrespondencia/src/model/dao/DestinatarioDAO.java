package model.dao;
import exceptions.PessoaNaoAutorizadaException;
import model.Destinatario;
import java.util.ArrayList;
import java.util.List;


public class DestinatarioDAO implements OperacoesDAO<Destinatario> {

    private ArrayList<Destinatario> listaDestinatarios = new ArrayList<Destinatario>(); //precisa ser final?

 /*public Destinatario pesquisaDestinatario(String nome) {
        return null;
    }  Substituir isso aqui nas interfaces depois*/


    @Override
    public boolean inserir(Destinatario obj) {
        return listaDestinatarios.add(obj);
    }

    @Override
    public boolean excluir(Destinatario obj) {
       return listaDestinatarios.remove(obj);
    }

    @Override
    public void editar(Destinatario newObj) {
//não implementado pois não é utilizado nas funcionalidades
    }

    @Override
    public List<Destinatario> pesquisar() {
        return null;
    }

    //modificar os a seguir

    //pesquisa se autorizado está na lista do destinatário --fazer!!

    //pesquisa se destinatario existe cadastrado
    public boolean pesquisarCadastro(Destinatario destinatario) throws DestinatarioJaCadastradoException {
        for(Destinatario cadastro : listaDestinatarios) {
            if(cadastro.equals(destinatario)) {
                throw new DestinatarioJaCadastradoException();
            }
        } return true;
    }

    //procura o destinatário no banco de dados pelo nome
    public Destinatario pesquisarDestinatario(String nome) throws DestinatarioInexistenteException {
        for(Destinatario destinatario : listaDestinatarios) {
            if(destinatario.getNome().equalsIgnoreCase(nome)) {
                return destinatario;
            }
        }
        throw new DestinatarioInexistenteException();
    }


    //procura o destinatário no banco de dados pelo numero do apartamento
    public Destinatario pesquisarPorNumero(String numero) throws DestinatarioInexistenteException {
        for(Destinatario destinatario : listaDestinatarios) {
            if(destinatario.getNumeroImovel().equalsIgnoreCase(numero)) {
                return destinatario;
            }
        }
        throw new DestinatarioInexistenteException();
    }
    //public List<String> getAutorizados() { return autorizados; }
    //  public List<Movimento> pesquisaData(String data) {
    //        List<Movimento> movimentos = new ArrayList<>();
    //        for(Movimento movimento : bancoDeDados.getMovimentos()) {
    //            if (movimento.getDataFormatada().equals(data)) {
    //                movimentos.add(movimento);
    //            }
    //        }
    //        return movimentos;
    //    }


    //pesquisa e retorna uma lista com todas movimentaçoes de um determinado morador
  /*  public List<Movimento> pesquisaDestinatario(Destinatario destinatario) {
        List<Movimento> movimentos = new ArrayList<>();
        if (destinatario == null) {
            return movimentos;
        }
        for(Movimento movimento : bancoDeDados.getMovimentos()) {
            Destinatario destinatarioMovimento = movimento.getCorrespondencia().getDestino();
            if (destinatarioMovimento.equals(destinatario)) {
                movimentos.add(movimento);
            }
        }
        return movimentos;
    }*/
    //fazer código para lista de autorizados
    public Destinatario conferenciaAutorizado(List<String> autorizados ) throws PessoaNaoAutorizadaException {
        for(Destinatario autorizados : listaDestinatarios) {
            if(Destinatario.getAutorizados().equalsIgnoreCase(autorizados)) {
                return autorizados;
            }
        }
        throw new PessoaNaoAutorizadaException();
    }
}
