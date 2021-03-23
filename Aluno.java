public class Aluno implements Pessoa {

    private int matricula;
    private String nome;
    private int idade;
    

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome=nome;
    }

    @Override
    public int getIdade() {
        return idade;
    }

    @Override
    public void setIdade(int idade) {
        this.idade=idade;
    }

   
    public int getMatricula() {
        return matricula;
    }

  
    public void setMatricula(int matricula) {
        this.matricula=matricula;
    }

    @Override
    public String toString(){
        return " \n  Nome:      "+ nome + "\n  Idade:     " + idade + "\n  Matricula: " + matricula+"\n";
    }

}