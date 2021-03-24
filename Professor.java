public class Professor implements Pessoa {

    private int certificado;
    private String nome;
    private int idade;
    private int id;
    

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

    public int getAnoCertificado() {
        return certificado;
    }

    public void setAnoCertificado(int certificado) {
        this.certificado = certificado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return " \n  Nome:      "+ nome + "\n  Idade:     " + idade + "\n  Certificado " + certificado+ "\n  Id:     " + id + "\n" ;
    }
    
}
