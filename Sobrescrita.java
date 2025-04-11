//Sobrescrita equals()

class Turma {

    private String nome;
    private String cpf;
    private String dataNascimento;

    public Turma(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object obj) {
        Turma outraTurma = (Turma) obj;
        return this.cpf.equals(outraTurma.cpf); //Pessoas são iguais pelo cpf
    }


}

public class Sobrescrita {

    public static void main(String[] args) {
        
        Turma pessoa1 = new Turma("João", "111.111.111-11", "01/01/2000");
        Turma pessoa2 = new Turma("Maria", "111.111.111-11", "02/02/2000");

        boolean retorno;

        retorno = pessoa1.equals(pessoa2);

        System.out.println("As duas pessoas são iguais? " + retorno);
    }

}
