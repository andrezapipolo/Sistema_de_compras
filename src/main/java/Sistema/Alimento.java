package Sistema;

public class Alimento extends ProdutoBase {
    public String dataValidade;

    public Alimento(String nome, double preco, String dataValidade, int quantidade) {
        super(nome, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    public Alimento() {}

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

        public String getTipo() {
        return "Alimento";
    }


    public String exibirDetalhes() {
        return String.format("Tipo: %s, Nome: %s, Preço: %.2f, Quantidade: %d, Data de Validade: %s",
                getTipo(), getNome(), getPreco(), getQuantidade(), dataValidade);
    }
}
