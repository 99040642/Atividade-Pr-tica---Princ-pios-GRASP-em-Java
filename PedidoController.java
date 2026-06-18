public class PedidoController {

    private Pedido pedido;

    public PedidoController() {
        pedido = new Pedido();
    }

    // GRASP - Controller
    public void adicionarProduto(Produto produto, int quantidade) {
        pedido.adicionarItem(produto, quantidade);
    }

    public double obterTotalPedido() {
        return pedido.calcularTotal();
    }

    public Pedido getPedido() {
        return pedido;
    }
}