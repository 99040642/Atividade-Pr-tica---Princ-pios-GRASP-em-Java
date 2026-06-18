package modelo;

public class ItemPedido {
    private String nomeProduto;
    private double preco;
    private int quantidade;

    public ItemPedido(String nomeProduto, double preco, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantity;
    }

    public double getSubtotal() {
        return preco * quantidade;
    }

    public String getNomeProduto() { 
        return nomeProduto; 
    }
}