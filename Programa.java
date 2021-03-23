import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class Programa {

    private static final int IDADE_MINIMA = 18;
    private static final int IDADE_MAXIMA = 70;
    private static final int NOME_MINIMO = 3;
    private static final int NOME_MAXIMO = 50;
    private static final int MATRICULA_MINIMA = 0;
    private static final int MATRICULA_MAXIMA = 9999;
    private static final String ERRO = "\nErro\n";
    private static Scanner scan;
    
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
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        Map <String, Integer> chaveMatricula = new TreeMap <>();
        List <Aluno> alunos = new ArrayList<>(); 
        List <Professor> professores = new ArrayList<>();

        System.out.println("\n---------Escolha o tipo de cadastro---------\n\ndigite \"criar\" para um novo cadastro \"encerrar\" para encerrar o programa\nR:");
        System.out.println("\n---------Cadastro de Professores---------\n\ndigite \"criar\" para um novo cadastro \"encerrar\" para encerrar o programa\nR:");


        System.out.println("\n---------Cadastro de alunos---------\n\ndigite \"criar\" para um novo cadastro \"encerrar\" para encerrar o programa\nR:");
        Controle controle = Controle.valueOf(scan.next().toUpperCase()); 
        
        if(isVerificarControleValido(controle)) {
            System.out.println(ERRO);
            System.exit(0);
        }

            while(isVerificarControleCriar(controle)) {
                Aluno aluno = new Aluno();
                Professor professor = new Professor();
                UniversidadeX usp = new UniversidadeX();
                
                System.out.println("\nCadastro\n");
                System.out.println("\nDigite o nome(minimo 3 caracteres, e começar com letra maiúscula):\nR:");
                aluno.setNome(scan.next());

                    if(isVerificarNomeInvalido(aluno)) {
                        System.out.println(ERRO);
                        System.exit(0);
                    }
                    else if(isVerificarNomeMinuscula(aluno)) {
                        System.out.println(ERRO);
                        System.exit(0);
                    }

                System.out.println("\nDigite a idade(entre 18 e 70 anos):\nR:");
                aluno.setIdade(scan.nextInt());

                    if(isVerificarIdadeNaoPermitida(aluno)) {
                        System.out.println(ERRO);
                        System.exit(0);
                    }
                
                System.out.println("\nA pessoa a ser cadastrada é aluno ou professor?");
                System.out.println("\nDigite ALUNO OU PROFESSOR:\nR:");
                Opcao opcao = Opcao.valueOf(scan.next().toUpperCase());
                
                if(opcao == Opcao.ALUNO){

                    System.out.println("\nDigite a matricula(entre 0 e 9999):\nR:");
                    aluno.setMatricula(scan.nextInt());

                    if(isVerificarMatriculaInvalida(aluno)) {
                        System.out.println(ERRO);
                        System.exit(0);
                    }
                
                alunos.add(aluno);
                
                chaveMatricula.put(aluno.getNome(),aluno.getMatricula());

                }
                else if(opcao == Opcao.PROFESSOR){

                    System.out.println("\nDigite o certificado:\n Graduação, pós graduação,mestrado ou doutorado:\nR:");
                    professor.setCertificado(scan.nextInt());

                    if(professor.getCertificado() != 1 ) {
                        System.out.println(ERRO);
                        System.exit(0);
                    }
                
                alunos.add(aluno);
                chaveMatricula.put(aluno.getNome(),aluno.getMatricula());

                }

                System.out.println("\nAluno cadastrado, digite \"criar\" para um novo cadastro,  \"alterar\" para alterar um cadastro, \"deletar\" para excluir um cadastro,  \"ver\" para ver a lista de alunos cadastrados e \"encerrar\" para encerrar o programa:\nR:");
                controle = Controle.valueOf(scan.next().toUpperCase());

                if(isVerificarControleVer(controle)){
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print( alunos+"\n\n");
                        System.out.println("digite \"criar\" para um novo cadastro, e \"encerrar\" para fechar o programa\n");
                        controle = Controle.valueOf(scan.next().toUpperCase());
                }      

                else if (isVerificarControleEncerrar(controle)) {

                    System.out.println("\nEncerrando...\n");    
                    System.exit(0);
                }

                
                   
                while(isVerificarControleAlterar(controle)){
                    
                    System.out.print("\n------Ver lista-----\n\n");
                    System.out.print(alunos+"\n"+chaveMatricula.entrySet()+"\n\n");
                    System.out.print("Qual matricula deseja alterar?\n");
                    chaveMatricula.put(aluno.getNome(),scan.nextInt());
                    
                    System.out.println("Qual a nova matricula?:  ");
                    aluno.setMatricula(scan.nextInt());
                    chaveMatricula.put(aluno.getNome(),aluno.getMatricula()) ;
                
                    System.out.print(chaveMatricula.entrySet()+"\n\n");
                    System.out.print(alunos+"\n"+chaveMatricula.entrySet()+"\n\n");

                    controle = Controle.valueOf(scan.next().toUpperCase());

                    if (isVerificarControleEncerrar(controle)){
                        System.exit(0);
                    }
                    else if(isVerificarControleCriar(controle)){                            
                        isVerificarControleCriar(controle);
                    }
                    else{
                        System.out.println(ERRO);
                        System.exit(0);
                    }
                }
                if (isVerificarControleDeletar(controle)) {
                    System.out.print("\nQual cadastro você quer deletar(contagem inicia no 0)\n\n");
                    alunos.remove(alunos.get(scan.nextInt()));
                    System.out.print("\n------Ver lista-----\n\n");
                    System.out.print(alunos+"\n\n");
                }
            }   
    }
}    



        

    


