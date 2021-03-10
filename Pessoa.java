public class Pessoa {

    String nome;
    int idade;
    int matricula;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome=nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade=idade;
    }

    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula=matricula;
    }

    public String toString(){
        return nome + " " + idade + " " + matricula;
    }

}