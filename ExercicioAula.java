import java.util.HashMap;
import java.util.Scanner;


public class ExercicioAula {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        HashMap<String, String> cadastro = new HashMap<>();

        String nomeCompleto;
        String email;


        while (true) { 
            
            String vetorNome[];

            //Recebendo nome e conferindo se está completo.
            do { 
            System.out.println("Digite o nome completo: ");
            nomeCompleto = entrada.nextLine().toUpperCase();
            vetorNome = nomeCompleto.split(" ");
            } while(vetorNome.length < 2);

            //Gerando email e mostrando.
            System.out.println("\nGerando email");
            email = vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + "@ufn.edu.br";
            email = email.toLowerCase();
            System.out.println(email + "\n");

            //Verificando se a chave(email) já está cadastrada.
            if(cadastro.containsKey(email)){
                int repetiuEmail = 2;

                //Gerar email adicionando um valor(repetiuEmail) no final do nome.
                while(true) { 
                    email = vetorNome[0] + "." + vetorNome[vetorNome.length - 1] + repetiuEmail +"@ufn.edu.br";
                    email = email.toLowerCase();
                    repetiuEmail++;

                    //Mostrando email novo.
                    if(!cadastro.containsKey(email)){
                        System.out.println("Email já está cadastrado\n");
                        System.out.println("Novo email: "+ email +"\n");
                        break;
                    }
                }
            }

            //Adicionando novo par chave-valor.
            cadastro.put(email, nomeCompleto);

            //Verificar se deseja receber outro nome.
            System.out.println("Deseja receber outro nome? (S ou N)");
            char continuar = entrada.next().charAt(0);

            if(Character.toUpperCase(continuar) == 'S'){ 
                entrada.nextLine();
            }
            else{
                entrada.nextLine();
                break;
            }
            
        }


        //Mostrando cada chave e seu respectivo valor.
        for (String chave : cadastro.keySet()) {
            System.out.println("Chave(email): " + chave + ", Valor(nome completo): " + cadastro.get(chave));
        }

        entrada.close();
    }
}
