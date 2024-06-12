package Sistema;

public class Principal {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho1 = new CarrinhoDeCompras();
        CarrinhoDeCompras carrinho2 = new CarrinhoDeCompras();

        Eletronico eletronico = new Eletronico("Smart TV", 2999.0, 12, 1);
        Roupa roupa = new Roupa("Vestido", 189.99, "M", "Branco", 1);
        Alimento alimento = new Alimento("Macarrão sem Glúten", 2.99, "01/01/2025", 5);

        carrinho1.adicionarItem(eletronico);
        carrinho1.adicionarItem(roupa);
        carrinho1.adicionarItem(alimento);

        carrinho2.adicionarItem(new Eletronico("Webcam", 99.90, 24, 1));
        carrinho2.adicionarItem(new Roupa("Calça", 199.99, "42", "Jeans", 2));
        carrinho2.adicionarItem(new Alimento("Lentilha", 3.99, "01/06/2024", 5));

        System.out.println("Carrinho 1:");
        carrinho1.listarItens();
        System.out.println("Total: " + carrinho1.calcularTotal());
        carrinho1.gerarArquivoTexto("carrinho1.txt");

        System.out.println("Carrinho 2:");
        carrinho2.listarItens();
        System.out.println("Total: " + carrinho2.calcularTotal());
        carrinho2.gerarArquivoTexto("carrinho2.txt");
    }
}
