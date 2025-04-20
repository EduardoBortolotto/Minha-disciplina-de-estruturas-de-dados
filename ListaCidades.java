import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cidade {

    private String nome;
    private String siglaEstado;

    public Cidade(String nome, String siglaEstado) {
        this.nome = nome.toUpperCase();
        this.siglaEstado = siglaEstado.toUpperCase();
    }

    public String getNome() {
        return nome;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    @Override
    public String toString() {
        return "Cidade: " + nome + ", Estado: " + siglaEstado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((siglaEstado == null) ? 0 : siglaEstado.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cidade other = (Cidade) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (siglaEstado == null) {
            if (other.siglaEstado != null)
                return false;
        } else if (!siglaEstado.equals(other.siglaEstado))
            return false;
        return true;
    }

    
}

public class ListaCidades {

    public static void cadastrarCidade(List<Cidade> cidades) {
        Scanner sc = new Scanner(System.in);
        String nome, estado;

        System.out.print("Digite o nome da cidade: ");
        nome = sc.nextLine().toUpperCase();
        System.out.print("Digite a sigla do estado: ");
        estado = sc.nextLine().toUpperCase();
        Cidade cidade = new Cidade(nome, estado);
        if (cidades.contains(cidade)) {
            System.out.println("Cidade já cadastrada neste Estado.");
        } else {
            cidades.add(cidade);
            System.out.println("Cidade cadastrada com sucesso.");
        }
        
    }

    public static void listarCidades(List<Cidade> cidades) {
        if (cidades.isEmpty()) {
            System.out.println("Nenhuma cidade cadastrada.");
        } else {
            cidades.sort((c1, c2) -> c1.getNome().compareTo(c2.getNome()));
            for (Cidade cidade : cidades) {
                System.out.println(cidade);
            }
        }
    }

    public static void pesquisarCidade(List<Cidade> cidades) {
        Scanner sc = new Scanner(System.in);
        String nome, estado;

        System.out.print("Digite o nome da cidade: ");
        nome = sc.nextLine().toUpperCase();
        System.out.println("Digite a sigla do Estado: ");
        estado = sc.nextLine().toUpperCase();
        for (Cidade cidade : cidades) {
            if (cidade.getNome().equals(nome) && cidade.getSiglaEstado().equals(estado)) {
                System.out.println("Cidade encontrada: " + cidade);
                return;
            }
        }
        System.out.println("Cidade não encontrada.");
    }

    public static void removerCidade(List<Cidade> cidades) {
        Scanner sc = new Scanner(System.in);
        String nome, estado;

        System.out.print("Digite o nome da cidade: ");
        nome = sc.nextLine().toUpperCase();
        System.out.println("Digite a sigla do Estado: ");
        estado = sc.nextLine().toUpperCase();
        Cidade cidade = new Cidade(nome, estado);
        if (cidades.remove(cidade)) {
            System.out.println("Cidade removida com sucesso.");
        } else {
            System.out.println("Cidade não encontrada.");
        }
    }

    public static void main(String[] args) {

        List<Cidade> cidades = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        char opcao;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar cidade");
            System.out.println("2. Listar cidades");
            System.out.println("3. Pesquisar cidade");
            System.out.println("4. Remover cidade");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.next().charAt(0);
            sc.nextLine(); 

            ListaCidades listaCidades = new ListaCidades();

            switch (opcao) {
                case '1':
                    listaCidades.cadastrarCidade(cidades);
                    break;
                case '2':
                    listaCidades.listarCidades(cidades);
                    break;
                case '3':
                    listaCidades.pesquisarCidade(cidades);
                    break;
                case '4':
                    listaCidades.removerCidade(cidades);
                    break;
                case '5':
                    System.out.println("Fim do programa.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }


}
