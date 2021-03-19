import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Map;


public class Programa {

    private static final int IDADE_MINIMA = 18;
    private static final int IDADE_MAXIMA = 70;
    private static final int NOME_MINIMO = 3;
    private static final int NOME_MAXIMO = 50;
    private static final int MATRICULA_MINIMA = 0;
    private static final int MATRICULA_MAXIMA = 9999;
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

    public static boolean isVerificarNomeInvalido(Pessoa pessoa) {
        String nome = pessoa.getNome();
        int tamanho = nome.length(); 
        return tamanho < NOME_MINIMO || tamanho > NOME_MAXIMO;
         
    }

    public static boolean isVerificarNomeMinuscula(Pessoa pessoa) {
        String nome = pessoa.getNome();
        String letraInicial = nome.substring(0,1);
        String minuscula = letraInicial.toLowerCase();
        return letraInicial.equals(minuscula);
    }

    public static boolean isVerificarIdadeNaoPermitida(Pessoa pessoa) {
        int idadePessoa = pessoa.getIdade();
        return idadePessoa < IDADE_MINIMA || idadePessoa > IDADE_MAXIMA;
    }

    public static boolean isVerificarMatriculaInvalida(Pessoa pessoa) {
        int matriculaPessoa = pessoa.getMatricula();
        return matriculaPessoa < MATRICULA_MINIMA || matriculaPessoa > MATRICULA_MAXIMA;
    }

    public static boolean isVerificarControleValido(Controle controle){
        boolean isControleAlterarOuVer = isVerificarControleAlterar(controle)||isVerificarControleVer(controle);
        boolean isControleEncerrarOuDeletar = isVerificarControleEncerrar(controle)||isVerificarControleDeletar(controle);
        return isControleAlterarOuVer||isControleEncerrarOuDeletar;
    }
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        Map <String, Integer> chaveMatricula = new HashMap <>();
        List <Pessoa> pessoas = new ArrayList<>(); 
        System.out.println("\n---------Cadastro de alunos---------\n\ndigite \"criar\" para um novo cadastro \"encerrar\" para encerrar o programa\nR:");
        Controle controle = Controle.valueOf(scan.next().toUpperCase()); 
        
        if(isVerificarControleValido(controle)) {
            System.out.println("Não existe nenhum cadastro");
            System.exit(0);
        }

            while(isVerificarControleCriar(controle)) {
                Pessoa pessoa = new Pessoa();
                System.out.println("\nCadastro\n");
                System.out.println("\nDigite o nome(minimo 3 caracteres, e começar com letra maiúscula):\nR:");
                pessoa.setNome(scan.next());

                    if(isVerificarNomeInvalido(pessoa)) {
                        System.out.println("\nErro, nome tem que ter apenas letras (minimo 3 caracteres)\nEncerrando....\n");
                        System.exit(0);
                    }
                    else if(isVerificarNomeMinuscula(pessoa)) {
                        System.out.println("\nErro, nome tem que ter que começar com letra maiúscula\nEncerrando....\n");
                        System.exit(0);
                    }

                System.out.println("\nDigite a idade(entre 18 e 70 anos):\nR:");
                pessoa.setIdade(scan.nextInt());

                    if(isVerificarIdadeNaoPermitida(pessoa)) {
                        System.out.println("\nerro, idade não permitida\nEncerrando....\n");
                        System.exit(0);
                    }
            
                System.out.println("\nDigite a matricula(entre 0 e 9999):\nR:");
                pessoa.setMatricula(scan.nextInt());

                    if(isVerificarMatriculaInvalida(pessoa)) {
                        System.out.println("\nerro, matricula não encontrada, deve ser entre 1 e 9999 \nEncerrando....\n");
                        System.exit(0);
                    }
                
                pessoas.add(pessoa);
                chaveMatricula.put("matricula",pessoa.getMatricula());
                System.out.println("\nAluno cadastrado, digite \"criar\" para um novo cadastro,  \"alterar\" para alterar um cadastro, \"deletar\" para excluir um cadastro,  \"ver\" para ver a lista de alunos cadastrados e \"encerrar\" para encerrar o programa:\nR:");
                controle = Controle.valueOf(scan.next().toUpperCase());

                if(isVerificarControleVer(controle)){
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print( pessoas+"\n\n");
                }      

                else if (isVerificarControleEncerrar(controle)) {

                    System.out.println("\nEncerrando...\n");    
                    System.exit(0);
                }

                else if (isVerificarControleAlterar(controle)) {
                   
                    while(isVerificarControleAlterar(controle)){
                        
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print(pessoas+"\n"+chaveMatricula.values()+"\n\n");
                        System.out.print("Qual matricula deseja alterar(a contagem inicia do 0)\n?");
                        
                        System.out.println("Qual a nova matricula?:  ");
                        
                        controle = Controle.valueOf(scan.next().toUpperCase());

                        if (isVerificarControleEncerrar(controle)){
                            System.exit(0);
                        }
                        else if(isVerificarControleCriar(controle)){                            
                            isVerificarControleCriar(controle);
                        }
                        else{
                            System.out.println("erro");
                            System.exit(0);
                        }
                    }
                }
                else if (isVerificarControleDeletar(controle)) {
                    System.out.print("\nQual cadastro você quer deletar(contagem inicia no 0)\n\n");
                    pessoas.remove(pessoas.get(scan.nextInt()));
                    System.out.print("\n------Ver lista-----\n\n");
                    System.out.print(pessoas+"\n\n");
                }
            }   
    }
}    



        

    


