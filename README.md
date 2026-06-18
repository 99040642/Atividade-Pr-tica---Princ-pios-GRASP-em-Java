# Atividade Prática - Princípios GRASP em Java

Este repositório contém a implementação de um sistema simplificado de controle de pedidos comerciais desenvolvido com o objetivo de consolidar a aplicação prática dos padrões de atribuição de responsabilidades do **GRASP (General Responsibility Assignment Software Patterns)**.

## Padrões GRASP Utilizados

1. **Creator (Criador):** - **Onde:** Aplicado no método `adicionarItem` da classe `Pedido`.
   - **Justificativa:** A classe `Pedido` compõe e agrega objetos do tipo `ItemPedido`. Seguindo as diretrizes do GRASP, a responsabilidade de instanciar `ItemPedido` foi atribuída diretamente a `Pedido`, evitando acoplamento desnecessário de fábricas externas ou da camada de controle com os detalhes internos de construção do item.

2. **Controller (Controlador):**
   - **Onde:** Centralizado na classe `PedidoController`.
   - **Justificativa:** Atua como o primeiro ponto de contato que recebe e coordena as operações do sistema originadas pela interface (classe `Main`), isolando a lógica de apresentação das regras e modelos de negócio da aplicação.

## Como Executar o Projeto

Certifique-se de ter o JDK instalado em sua máquina. A partir da pasta raiz do projeto (`meu-projeto-grasp`), utilize os comandos:

```bash
# Compilar os arquivos a partir da pasta src
javac src/modelo/*.java src/controlador/*.java src/Main.java -d bin

# Executar a aplicação
java -cp bin Main
