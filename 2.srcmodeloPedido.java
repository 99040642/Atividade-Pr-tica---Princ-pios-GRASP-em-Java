package modelo;

import java.util.ArrayList;
import java.util.List;

/*
 * JUSTIFICATIVA GRASP: PADRÃO CREATOR (CRIADOR)
 * * Onde foi aplicado: No método 'adicionarItem' da classe Pedido.
 * * Por que atende ao princípio: De acordo com o GRASP, uma classe B deve ser responsável por criar
 * instâncias de uma classe A se B contém, agrega ou usa estritamente A. 
 * Como o 'Pedido' possui uma lista de 'ItemPedido' e esses itens não fazem sentido existirem de forma isolada sem um pedido,
 * o próprio Pedido recebe os dados brutos e instancia o objeto ItemPedido internamente.
 * Isso evita que classes externas precisem conhecer a existência ou a mecânica de construção de ItemPedido, 
 * melhorando o encapsulamento e a coesão.
 */
public class Pedido {
    private int id;
    private List<ItemPedido> itens;

    public Pedido(int id) {
        this.id = id;
        this.itens = new ArrayList<>();
    }

    // O método recebe os parâmetros e CRIA o objeto internamente (Creator)
    public void adicionarItem(String nomeProduto, double preco, int quantidade) {
        ItemPedido novoItem = new ItemPedido(nomeProduto, preco, quantidade);
        this.itens.add(novoItem);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    public int getId() { 
        return id; 
    }
    
    public List<ItemPedido> getItens() { 
        return itens; 
    }
}