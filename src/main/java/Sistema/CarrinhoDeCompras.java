package Sistema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    public List<Produto> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public void removerItem(Produto produto) {
        itens.removeIf(p -> p.getNome().equals(produto.getNome()) && p.getQuantidade() == produto.getQuantidade());
    }

    public void listarItens() {
        for (Produto produto : itens) {
            System.out.println(produto.exibirDetalhes());
        }
    }

    public List<Produto> exportarListaProdutos() {
        return new ArrayList<>(itens);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(p -> p.getPreco() * p.getQuantidade()).sum();
    }

    public void gerarArquivoTexto(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("item:\t\tQtd:\t\tNome:\t\tPreço:\t\t SubTotal:\n");
            int index = 1;
            for (Produto produto : itens) {
                double subTotal = produto.getPreco() * produto.getQuantidade();
                writer.write(String.format("%d\t\t%d\t\t%s\t\t%.2f\t\t%.2f\n",
                        index++, produto.getQuantidade(), produto.getNome(), produto.getPreco(), subTotal));
            }
            writer.write(String.format("Total: %.2f\n", calcularTotal()));
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo de texto: " + e.getMessage());
        }
    }
}
