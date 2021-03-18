import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.Map;

public class Programa {
    
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

    public static boolean isVerificarNomeMinimo(Pessoa pessoa) {
        String nome = pessoa.getNome();
        int tamanho = nome.length(); 
        return tamanho < 3 || tamanho > 50;
         
    }

    public static boolean isVerificarNomeMaiuscula(Pessoa pessoa) {
        String nome = pessoa.getNome();
        String letraMaiuscula = nome.toLowerCase();
        return nome.startsWith(letraMaiuscula);
    }

    public static boolean isVerificarIdadePermitida(Pessoa pessoa) {
        int idadePessoa = pessoa.getIdade();
        return idadePessoa < 18 || idadePessoa > 70;
    }

    public static boolean isVerificarMatriculaValida(Pessoa pessoa) {
        int matriculaPessoa = pessoa.getMatricula();
        return matriculaPessoa < 0 || matriculaPessoa > 9999;
    }

    public static void main(String[] args) {

        scan = new Scanner(System.in);
        Map <String, Integer> mapaNomes = new HashMap <String, Integer>();
        List <Pessoa> pessoas = new ArrayList<>(); 
       
        System.out.println("\n---------Cadastro de alunos---------\n\ndigite \"criar\" para um novo cadastro \"encerrar\" para encerrar o programa\nR:");
        Controle controle = Controle.valueOf(scan.next().toUpperCase()); 
        
        if(isVerificarControleVer(controle)||isVerificarControleAlterar(controle)||isVerificarControleEncerrar(controle)||isVerificarControleDeletar(controle)) {
            System.out.println("Não existe nenhum cadastro");
            System.exit(0);
        }
        
            while(isVerificarControleCriar(controle)) {
                Pessoa pessoa = new Pessoa();
            
                System.out.println("\nCadastro\n");
                System.out.println("\nDigite o nome(minimo 3 caracteres, e começar com letra maiúscula):\nR:");
                pessoa.setNome(scan.next());

                    if(isVerificarNomeMinimo(pessoa)) {
                        System.out.println("\nErro, nome tem que ter apenas letras (minimo 3 caracteres)\nEncerrando....\n");
                        System.exit(0);
                    }
                    else if(isVerificarNomeMaiuscula(pessoa)) {
                        System.out.println("\nErro, nome tem que ter que começar com letra maiúscula\nEncerrando....\n");
                        System.exit(0);
                    }

                System.out.println("\nDigite a idade(entre 18 e 70 anos):\nR:");
                pessoa.setIdade(scan.nextInt());

                    if(isVerificarIdadePermitida(pessoa)) {
                        System.out.println("\nerro, idade não permitida\nEncerrando....\n");
                        System.exit(0);
                    }
            
                System.out.println("\nDigite a matricula(entre 0 e 9999):\nR:");
                pessoa.setMatricula(scan.nextInt());

                    if(isVerificarMatriculaValida(pessoa)) {
                        System.out.println("\nerro, matricula não encontrada, deve ser entre 1 e 9999 \nEncerrando....\n");
                        System.exit(0);
                    }
                
                pessoas.add(pessoa);
                mapaNomes.put("matricula",pessoa.getMatricula());
                System.out.println("\nAluno cadastrado, digite \"criar\" para um novo cadastro,  \"alterar\" para alterar um cadastro, \"deletar\" para excluir um cadastro,  \"ver\" para ver a lista de alunos cadastrados e \"encerrar\" para encerrar o programa:\nR:");
                controle = Controle.valueOf(scan.next().toUpperCase());

                if(isVerificarControleVer(controle)){
                   
                        System.out.print("\n------Ver lista-----\n\n");
                        
                        System.out.print( pessoas+"\n\n");

                        Set< String  > keys = mapaNomes.keySet(); 
                        Set< String > sortedKeys= new TreeSet< String >( keys );

                        System.out.println( "O mapa contém:\nKey\t\tValue" ); 

                        for ( String key : sortedKeys)
                        System.out.printf ( "%s\t%s%n", key, mapaNomes.get( key ) );
                    
                }      

                else if (isVerificarControleEncerrar(controle)) {

                    System.out.println("\nEncerrando...\n");    
                    System.exit(0);
                }

                else if (isVerificarControleAlterar(controle)) {
                   
                    while(isVerificarControleAlterar(controle)){
                        
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print(pessoas+"\n\n");
                        System.out.print("Qual cadastro deseja alterar(a contagem inicia do 0)\n?");
                        Pessoa posicaoCadastro = pessoas.get(scan.nextInt());

                        System.out.println("Qual o novo nome?:  ");
                        posicaoCadastro.setNome(scan.next());

                        System.out.println("Qual a nova idade?:  ");
                        posicaoCadastro.setIdade(scan.nextInt());

                        System.out.println("Qual a nova matricula?:  ");
                        posicaoCadastro.setMatricula(scan.nextInt());
                        System.out.print(pessoas+"\n\n");
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



        

    


