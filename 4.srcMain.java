import controlador.PedidoController;

public class Main {
    public static void main(String[] args) {
        // A camada de apresentação (Main) só interage com o Controller externo do sistema
        PedidoController sistema = new PedidoController();

        // Fluxo de execução simulando as ações do usuário:
        int idDoPedido = sistema.criarNovoPedido();
        
        sistema.adicionarItemAoPedido(idDoPedido, "Teclado Mecânico", 250.00, 1);
        sistema.adicionarItemAoPedido(idDoPedido, "Mouse Gamer", 120.00, 2);

        // Exibindo o resultado final coordenado pelo controlador
        sistema.exibirResumoPedido(idDoPedido);
    }
}