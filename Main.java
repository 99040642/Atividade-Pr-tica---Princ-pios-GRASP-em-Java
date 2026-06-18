public class Main {

    public static void main(String[] args) {

        Produto mouse = new Produto("Mouse Gamer", 150.00);
        Produto teclado = new Produto("Teclado Mecânico", 300.00);

        PedidoController controller = new PedidoController();

        controller.adicionarProduto(mouse, 2);
        controller.adicionarProduto(teclado, 1);

        System.out.println("Total do pedido: R$ " + controller.obterTotalPedido());
    }
}