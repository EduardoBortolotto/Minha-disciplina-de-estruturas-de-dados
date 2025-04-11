//Dicionário equipes

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExDicionario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, String> equipes = new HashMap<>();

        String nome, cidade;
        String opcao;

        while (true) {
            System.out.println("Digite o nome da equipe:");
            nome = sc.nextLine().toUpperCase();
            System.out.println("Digite a cidade da equipe:");
            cidade = sc.nextLine().toUpperCase();

            if (!equipes.containsKey(nome)) equipes.put(nome, cidade);
            else System.out.println("Essa equipe já existe!");

            System.out.println("Deseja continuar? (S) para sim ou outra teclas para não");
            opcao = sc.nextLine().toUpperCase();

            if (!opcao.equals("S")) {
                break;
            }
        }

        System.out.println("Equipes:");
        for (Map.Entry<String, String> entry : equipes.entrySet()) {
            System.out.println("Nome: " + entry.getKey() + ", Cidade: " + entry.getValue());
        }
        

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
