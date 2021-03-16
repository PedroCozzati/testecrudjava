import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class Programa {
    
    private static Scanner scan;
    public static void main (String[] args){

        scan = new Scanner(System.in);
        Map <String, String> mapaNomes = new HashMap <>();
        
        List <Pessoa> pessoas = new ArrayList<>(); 

        System.out.println("\n---------Cadastro de alunos---------\n\ndigite \"criar\" para um novo cadastro \"encerrar\" para encerrar o programa\nR:");
        Controle controle = Controle.valueOf(scan.next().toUpperCase()); 
        
        if(controle == Controle.VER){
            System.out.println("Não existe nenhum cadastro");
        }

        else if(controle == Controle.ENCERRAR) {
            System.out.println("\nEncerrando...\n");
            System.exit(0);
            
        }
        
             while (controle == Controle.CRIAR) {

                Pessoa pessoa = new Pessoa();
        
                System.out.println("\nCadastro\n");
                System.out.println("\nDigite o nome(minimo 3 caracteres, e começar com letra maiúscula):\nR:");
                
                pessoa.setNome(scan.next());

                    if (pessoa.getNome().length() < 3 || pessoa.getNome().length() > 50 ){
                    
                        System.out.println("\nErro, nome tem que ter apenas letras (minimo 3 caracteres)\nEncerrando....\n");
                        System.exit(0);
                    }
                    else if(pessoa.getNome().startsWith(pessoa.getNome().toLowerCase())){
                        System.out.println("\nErro, nome tem que ter que começar com letra maiúscula\nEncerrando....\n");
                        System.exit(0);
                    
                    }

                mapaNomes.put("nome",pessoa.getNome());

                System.out.println("\nDigite a idade(entre 18 e 70 anos):\nR:");
                pessoa.setIdade(scan.nextInt());

                    if (pessoa.getIdade() < 18 || pessoa.getIdade() > 70){

                        System.out.println("\nerro, idade não permitida\nEncerrando....\n");
                        System.exit(0);
                    }
            
                System.out.println("\nDigite a matricula(entre 0 e 9999):\nR:");
                pessoa.setMatricula(scan.nextInt());

                    if (pessoa.getMatricula() < 0 || pessoa.getMatricula() > 9999){

                        System.out.println("\nerro, matricula não encontrada, deve ser entre 1 e 9999 \nEncerrando....\n");
                        System.exit(0);
                    }
                   
                    
               
                pessoas.add(pessoa);
                System.out.println("\nAluno cadastrado, digite \"criar\" para um novo cadastro, \"ver\" para ver a lista de alunos cadastrados e \"encerrar\" para encerrar o programa:\nR:");
                controle = Controle.valueOf(scan.next().toUpperCase());

                if (controle == Controle.VER){

                    System.out.print("\n------Ver lista-----\n\n");
                    System.out.print(pessoas+"\n\n");
                    for (Map.Entry<String, String> entry : mapaNomes.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        System.out.println(String.format("key: %s | value: %s", key, value));
                    }
                    
                        
                }      

                if (controle == Controle.ENCERRAR){

                    System.out.println("\nEncerrando...\n");
                    System.exit(0);
                    
                }
                if (controle == Controle.ALTERAR){



                }

                if (controle == Controle.DELETAR){
                    pessoas.remove(pessoa);
                    System.out.print("\n------Ver lista-----\n\n");
                    System.out.print(pessoas+"\n\n");
                }
            }
    }
}    
   


        

    


