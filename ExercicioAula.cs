public class ExercicioAula
{
      static void Main()
    {
        Dictionary<string, string> cadastro = new Dictionary<string, string>();
        
        string nomeCompleto;
        string email;
        
        while (true)
        {
            string[] vetorNome;

            // Recebendo nome e conferindo se está completo.
            do
            {
                Console.WriteLine("Digite o nome completo: ");
                nomeCompleto = Console.ReadLine().ToUpper();
                vetorNome = nomeCompleto.Split(' ');
            } while (vetorNome.Length < 2);

            // Gerando email e mostrando.
            Console.WriteLine("\nGerando email...");
            email = $"{vetorNome[0]}.{vetorNome[vetorNome.Length - 1]}@ufn.edu.br".ToLower();
            Console.WriteLine(email + "\n");

            // Verificando se a chave (email) já está cadastrada.
            if (cadastro.ContainsKey(email))
            {
                int repetiuEmail = 2;

                // Gerar email novo adicionando um valor (repetiuEmail) no final do nome.
                while (true)
                {
                    email = $"{vetorNome[0]}.{vetorNome[vetorNome.Length - 1]}{repetiuEmail}@ufn.edu.br".ToLower();
                    repetiuEmail++;

                    // Mostrar email novo.
                    if (!cadastro.ContainsKey(email))
                    {
                        Console.WriteLine("Email já está cadastrado\n");
                        Console.WriteLine("Novo email: " + email + "\n");
                        break;
                    }
                }
            }

            // Adicionando novo par chave-valor.
            cadastro.Add(email, nomeCompleto);

            // Verificar se deseja receber outro nome.
            Console.WriteLine("Deseja receber outro nome? (S ou N)");
            char continuar = char.ToUpper(Console.ReadKey().KeyChar);

            if (continuar == 'S')
            {
                Console.WriteLine(); 
            }
            else 
            {
                Console.WriteLine();
                break;
            }
        }

        // Mostrando cada chave e seu respectivo valor.
        foreach (var entrada in cadastro)
        {
            Console.WriteLine($"Chave(email): {entrada.Key}, Valor(nome completo): {entrada.Value}");
        }
    }
}
