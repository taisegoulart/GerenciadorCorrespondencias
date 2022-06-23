package model.dao;
import java.util.List;
/*
 * OperacoesDAO.java
 *
 * Foi escolhida a collection ArrayList para implementar o gerenciador de correspondências, uma vez que era a mais
 * adequada  * para lidar com o problema porposto, pois:
 *
 * 1- Considerando que pode acontecer de chegar, num mesmo dia, mais de uma encomenda igual para o mesmo destinatário e
 * a modelagem não incluía um identificador (como por exemplo, um código de rastreio), em algum  momento poderíamos
 * ter objetos de valores repetidos (dois pacotes e uma carta para a professora Karen entregues dia  25 de junho,
 * por exemplo) e isso por si só inviabiliza o uso da Collection Set, onde não se pode ter registros
 * repetidos;
 * 2- Map também não poderia ser usado, já que as "regras" da Collection permitem que a mesma chave esteja associada a
 * diferentes valores, mas não que tenha duas chaves iguais, e como mencionado anteriormente, não temos nenhum atributo
 * "único": encomendas, destinatários, pessoas autorizadas, datas, todas podem acabar coexistindo com os mesmod valores
 * em algum momento;
 * 3- Não traria vantagens implementar pilha ou fila para lidar com as situações problemas, uma vez que FIFO e LIFO não
 * são úteis, já que as funcionalidades necessárias não estão relacionadas com uma ordem, mas sim com buscas de dados
 * específicos (como nome do destinatário e se há ou não uma pessoa correspondente à lista de autorizadas), então Queue
 * e Deque não foram consideradas.
 */
/**
 *
 * @author Taíse Goulart e Victor Belato
 *
 */
public interface OperacoesDAO<T> {
    /* Foi utilizado o método <T> T[]	toArray(T[] a) pois ele retorna um array ao invés de um objeto.
   Para a maior parte dos problemas, usa-se ele ao invés do toArray(), que devemos usar quando queremos um objeto de
   retorno.
   Referências:
   https://stackoverflow.com/questions/28392705/difference-between-toarrayt-a-and-toarray
   https://stackoverflow.com/questions/28392705/difference-between-toarrayt-a-and-toarray
   */
    public boolean inserir(T obj);

    public void excluir(T obj);

    public void editar(T newObj);
    //as funcionalidades requeridas para implementação não necessitam de uma função editar

    public List<T> pesquisar();
}


