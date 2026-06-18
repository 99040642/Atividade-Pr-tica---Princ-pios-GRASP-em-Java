import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ItemPedido> itens;

    public Pedido() {
        itens = new ArrayList<>();
    }

    // GRASP - Creator
    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}