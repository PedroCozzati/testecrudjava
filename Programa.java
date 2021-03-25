public class Programa {

    private static final int IDADE_MINIMA = 18;
    private static final int IDADE_MAXIMA = 70;
    private static final int NOME_MINIMO = 3;
    private static final int NOME_MAXIMO = 50;
    private static final int MATRICULA_MINIMA = 0;
    private static final int MATRICULA_MAXIMA = 9999;
   
    
    public static boolean isVerificarControleVer(Controle controle) {
        return controle == Controle.VER;
    }

    public static boolean isVerificarControleCriar(Controle controle) {
        return controle == Controle.CRIAR;

    }
    public static boolean isVerificarControleEncerrar(Controle controle) {
        return controle == Controle.ENCERRAR;

    }
    public static boolean isVerificarControleAlterar(Controle controle) {
        return controle == Controle.ALTERAR;

    }

    public static boolean isVerificarControleDeletar(Controle controle) {
        return controle == Controle.DELETAR;
    }

    public static boolean isVerificarNomeInvalido(Aluno aluno) {
        String nome = aluno.getNome();
        int tamanho = nome.length(); 
        return tamanho < NOME_MINIMO || tamanho > NOME_MAXIMO;
         
    }

    public static boolean isVerificarNomeMinuscula(Aluno aluno) {
        String nome = aluno.getNome();
        String letraInicial = nome.substring(0,1);
        String minuscula = letraInicial.toLowerCase();
        return letraInicial.equals(minuscula);
    }

    public static boolean isVerificarIdadeNaoPermitida(Aluno aluno) {
        int idadeAluno = aluno.getIdade();
        return idadeAluno < IDADE_MINIMA || idadeAluno > IDADE_MAXIMA;
    }

    public static boolean isVerificarMatriculaInvalida(Aluno aluno) {
        int matriculaAluno =aluno.getMatricula();
        return matriculaAluno < MATRICULA_MINIMA || matriculaAluno > MATRICULA_MAXIMA;
    }

    public static boolean isVerificarControleValido(Controle controle){
        boolean isControleAlterarOuVer = isVerificarControleAlterar(controle)||isVerificarControleVer(controle);
        boolean isControleEncerrarOuDeletar = isVerificarControleEncerrar(controle)||isVerificarControleDeletar(controle);
        return isControleAlterarOuVer||isControleEncerrarOuDeletar;
    }

}
        

    


