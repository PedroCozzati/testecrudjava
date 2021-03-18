import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.Map;

public class Programa {
    
    private static Scanner scan;
    
    public static boolean verificarControleVer (Controle controle){
        return controle == Controle.VER;
    }

    public static boolean verificarControleCRIAR (Controle controle){
        return controle == Controle.CRIAR;

    }
    public static boolean verificarControleENCERRAR (Controle controle){
        return controle == Controle.ENCERRAR;

    }
    public static boolean verificarControleALTERAR (Controle controle){
        return controle == Controle.ALTERAR;

    }
    public static boolean verificarControleDELETAR (Controle controle){
        return controle == Controle.DELETAR;
    }

    public static boolean verificarNomeMinimo (Pessoa pessoa){
        return pessoa.getNome().length() < 3 || pessoa.getNome().length() > 50; 
    }

    public static boolean verificarNomeMaiuscula (Pessoa pessoa){
        return pessoa.getNome().startsWith(pessoa.getNome().toLowerCase());
    }

    public static boolean verificarIdadePermitida (Pessoa pessoa){
        return pessoa.getIdade() < 18 || pessoa.getIdade() > 70;
    }

    public static boolean verificarMatriculaValida (Pessoa pessoa){
        return pessoa.getMatricula() < 0 || pessoa.getMatricula() > 9999;
    }

    public static void main (String[] args){

        scan = new Scanner(System.in);
        Map <String, Integer> mapaNomes = new HashMap <String, Integer>();
        
        List <Pessoa> pessoas = new ArrayList<>(); 
       
        System.out.println("\n---------Cadastro de alunos---------\n\ndigite \"criar\" para um novo cadastro \"encerrar\" para encerrar o programa\nR:");
        Controle controle = Controle.valueOf(scan.next().toUpperCase()); 
        
            if(verificarControleVer(controle)){
                System.out.println("Não existe nenhum cadastro");
                
            }

            else if(verificarControleENCERRAR(controle)) {
                System.out.println("\nEncerrando...\n");
                System.exit(0);
                
            }
            
                while (verificarControleCRIAR(controle)) {

                    Pessoa pessoa = new Pessoa();
            
                    System.out.println("\nCadastro\n");
                    System.out.println("\nDigite o nome(minimo 3 caracteres, e começar com letra maiúscula):\nR:");
                    
                    pessoa.setNome(scan.next());

                        if (verificarNomeMinimo(pessoa)){
                        
                            System.out.println("\nErro, nome tem que ter apenas letras (minimo 3 caracteres)\nEncerrando....\n");
                            System.exit(0);
                        }
                        else if(verificarNomeMaiuscula(pessoa)){
                            System.out.println("\nErro, nome tem que ter que começar com letra maiúscula\nEncerrando....\n");
                            System.exit(0);
                        
                        }


                    System.out.println("\nDigite a idade(entre 18 e 70 anos):\nR:");
                    pessoa.setIdade(scan.nextInt());

                        if (verificarIdadePermitida(pessoa)){

                            System.out.println("\nerro, idade não permitida\nEncerrando....\n");
                            System.exit(0);
                        }
                
                    System.out.println("\nDigite a matricula(entre 0 e 9999):\nR:");
                    pessoa.setMatricula(scan.nextInt());

                        if (verificarMatriculaValida(pessoa)){

                            System.out.println("\nerro, matricula não encontrada, deve ser entre 1 e 9999 \nEncerrando....\n");
                            System.exit(0);
                        }
                    
                    pessoas.add(pessoa);
                    mapaNomes.put("matricula",pessoa.getMatricula());
                    System.out.println("\nAluno cadastrado, digite \"criar\" para um novo cadastro, \"ver\" para ver a lista de alunos cadastrados e \"encerrar\" para encerrar o programa:\nR:");
                    controle = Controle.valueOf(scan.next().toUpperCase());

                    if (verificarControleVer(controle)){

                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print(pessoas+"\n\n");

                        Set< String  > keys = mapaNomes.keySet(); 
                        
                        TreeSet< String > sortedKeys= new TreeSet< String >( keys );
                        System.out.println( "O mapa contém:\nKey\t\tValue" ); 

                        for ( String key : sortedKeys)
                        System.out.printf ( "%s\t%s%n", key, mapaNomes.get( key ) );

                    }      

                    if (verificarControleENCERRAR(controle)){

                        System.out.println("\nEncerrando...\n");
                        System.exit(0);
                        
                    }
                    if (verificarControleALTERAR(controle)){
                    }

                    if (verificarControleDELETAR(controle)){
                        pessoas.remove(pessoa);
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print(pessoas+"\n\n");
                    }
                }
        
                  
    }
}    
   


        

    


