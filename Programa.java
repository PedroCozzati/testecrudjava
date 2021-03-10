import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Programa {
    
    private static Scanner scan;

    public static void main (String[] args){

        scan = new Scanner(System.in);
        
        List <Pessoa> pessoas = new ArrayList<>(); 

        System.out.println("\n---------Cadastro de alunos---------\n\ndigite \"criar\" para um novo cadastro");
        Controle dir = Controle.valueOf(scan.next().toUpperCase()); 

        while(dir == Controle.CRIAR) {

            Pessoa pessoa = new Pessoa();

            System.out.println("\nCadastro\n");

            System.out.println("\nDigite o nome:");
            pessoa.setNome(scan.next());

            System.out.println("\nDigite a idade:");
            pessoa.setIdade(scan.nextInt());

            System.out.println("\nDigite a matricula:");
            pessoa.setMatricula(scan.nextInt());

            pessoas.add(pessoa);

            System.out.println("\nAluno cadastrado, digite \"criar\" para um novo cadastro, \"ver\" para ver a lista de alunos cadastrados e \"encerrar\" para encerrar o programa:");
            dir = Controle.valueOf(scan.next().toUpperCase());

    
            if (dir == Controle.VER){

                System.out.print("\n------Ver lista-----\n\n");
                

                if (pessoas.isEmpty() ){

                    System.out.print("lista vazia, se quer continuar digite \"criar\"");
                    dir = Controle.valueOf(scan.next().toUpperCase());

                }

                else{
                    System.out.print(pessoas+"\n\n");
                }
                
            }      

            if (dir == Controle.ENCERRAR){

                System.out.println("\nEncerrando...\n");
            }
            
        }
        if(dir==Controle.ENCERRAR) {

            System.out.println("\nEncerrando...\n");
        }

    }    
   
} 

        

    


