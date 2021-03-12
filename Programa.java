import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Programa {
    
    private static Scanner scan;
    public static void main (String[] args){

        scan = new Scanner(System.in);
        List <Pessoa> pessoas = new ArrayList<>(); 

        System.out.println("\n---------Cadastro de alunos---------\n\ndigite \"criar\" para um novo cadastro \"encerrar\" para encerrar o programa");
        Controle dir = Controle.valueOf(scan.next().toUpperCase()); 
        
        if(dir == Controle.VER){
            System.out.println("Não existe nenhum cadastro");
        }
        else if(dir == Controle.ENCERRAR) {
            System.out.println("\nEncerrando...\n");
        }
        
            while (dir == Controle.CRIAR) {

                Pessoa pessoa = new Pessoa();
                System.out.println("\nCadastro\n");
                System.out.println("\nDigite o nome:");
                pessoa.setNome(scan.next());

                    if (pessoa.getNome().length() < 5 || pessoa.getNome().length() > 50){

                        System.out.println("\nErro, nome tem que ter apenas letras (minimo 5 caracteres)\nEncerrando....\n");
                        break;
                    }

                System.out.println("\nDigite a idade:");
                pessoa.setIdade(scan.nextInt());

                    if (pessoa.getIdade() < 18 || pessoa.getIdade() > 70){

                        System.out.println("\nerro, idade não permitida\nEncerrando....\n");
                        break;
                    }
            
                System.out.println("\nDigite a matricula:");
                pessoa.setMatricula(scan.nextInt());

                if (pessoa.getMatricula() < 0 || pessoa.getMatricula() > 9999){

                    System.out.println("\nerro, matricula não encontrada, deve ser entre 1 e 9999 \nEncerrando....\n");
                    break;
                }
                pessoas.add(pessoa);

                System.out.println("\nAluno cadastrado, digite \"criar\" para um novo cadastro, \"ver\" para ver a lista de alunos cadastrados e \"encerrar\" para encerrar o programa:");
                dir = Controle.valueOf(scan.next().toUpperCase());

                if (dir == Controle.VER){

                    System.out.print("\n------Ver lista-----\n\n");
                        System.out.print(pessoas+"\n\n");
                }      

                if (dir == Controle.ENCERRAR){

                    System.out.println("\nEncerrando...\n");
                    
                }
            }
    }
}    
   


        

    


