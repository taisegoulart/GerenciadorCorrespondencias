package model.dao;
import model.Correspondencia;
import model.Destinatario;
import model.Movimento;
import java.util.ArrayList;
import java.util.List;

public class MovimentoDAO implements OperacoesDAO<Movimento> {
    private ArrayList<Movimento> listaMovimentos = new ArrayList<Movimento>();


   // public MovimentoDAO() {
   //     super();
    //}

 //   public List<Movimento> pesquisaData(String dataPesquisada) {
  //      return null;
   // }

   /* public List<Movimento> pesquisaDestinatario(Destinatario destinatario) {
        return null;
    }*/

    @Override
    public boolean inserir(Movimento obj) {

        return false;
    }

    @Override
    public void excluir(Movimento obj) {

    }

    @Override
    public void editar(Movimento newObj) {

    }

    @Override
    public List<Movimento> pesquisar() {
        return

    }

    //modificar os a seguir
    //pesquisa e retorna uma lista com todas movimentaçoes de um determinado morador
    public List<Movimento> pesquisaDestinatario(Destinatario destinatario) {
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
    }


    private String normalizaTexto(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .replaceAll("\\s{2,}", " ")
                .trim()
                .toLowerCase(Locale.ROOT);
    }

    //pesquisa as movimentacoes por data
    public List<Movimento> pesquisaData(String data) {
        List<Movimento> movimentos = new ArrayList<>();
        for(Movimento movimento : bancoDeDados.getMovimentos()) {
            if (movimento.getDataFormatada().equals(data)) {
                movimentos.add(movimento);
            }
        }
        return movimentos;
    }

}
