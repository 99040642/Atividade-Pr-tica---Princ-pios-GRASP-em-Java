package controlador;

import modelo.Pedido;
import java.util.HashMap;
import java.util.Map;

/*
 * JUSTIFICATIVA GRASP: PADRÃO CONTROLLER (CONTROLADOR)
 * * Onde foi aplicado: Na classe PedidoController inteira, especificamente nos métodos que 
 * coordenam o fluxo do sistema (criarNovoPedido, adicionarItemAoPedido).
 * * Por que atende ao princípio: O GRASP determina que um Controller deve receber os eventos do sistema
 * (vindos da interface do usuário, CLI ou de uma API externa) e delegar as ações para os objetos de negócio correspondentes.
 * O controlador não calcula valores diretamente e nem altera atributos diretamente, apenas coordena as ações, garantindo 
 * que a camada de apresentação não se misture com as regras de negócio do domínio.
 */
public class PedidoController {
    private Map<Integer, Pedido> bancoDeDadosSimulado;
    private int proximoId;

    public PedidoController() {
        this.bancoDeDadosSimulado = new HashMap<>();
        this.proximoId = 1;
    }

    public int criarNovoPedido() {
        Pedido pedido = new Pedido(proximoId);
        bancoDeDadosSimulado.put(proximoId, pedido);
        int idCriado = proximoId;
        proximoId++;
        return idCriado;
    }

    public void adicionarItemAoPedido(int idPedido, String nome, double preco, int qtd) {
        Pedido pedido = bancoDeDadosSimulado.get(idPedido);
        if (pedido != null) {
            // Delega a criação para a classe Pedido (respeitando o Creator)
            pedido.adicionarItem(nome, preco, qtd);
        } else {
            System.out.println("Erro: Pedido não encontrado.");
        }
    }

    public void exibirResumoPedido(int idPedido) {
        Pedido pedido = bancoDeDadosSimulado.get(idPedido);
        if (pedido != null) {
            System.out.println("--- Resumo do Pedido #" + pedido.getId() + " ---");
            pedido.getItens().forEach(item -> 
                System.out.println("- " + item.getNomeProduto() + " | Qtd: " + item.getSubtotal() / item.getSubtotal() + " | Subtotal: R$ " + item.getSubtotal())
            );
            System.out.println("Total Geral do Pedido: R$ " + pedido.calcularTotal());
        }
    }
}