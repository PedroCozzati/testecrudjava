public class Pessoa implements Escola {

    private String nome;
    private int idade;
    private int matricula;

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
        return " \n  Nome:      "+ nome + "\n  Idade:     " + idade + "\n  Matricula: " + matricula+"\n";
    }

    @Override
    public void salaDoAluno() {
        
        System.out.println("\nAlunos da Sala:32");
        
    }

    @Override
    public void materias() {
        
        System.out.println("\nMatérias a estudar: Matematica,Portugues,Inglês");
        
    }

}