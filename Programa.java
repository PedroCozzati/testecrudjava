import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Programa {
    
    private static Scanner scan;

    public static void main (String[] args){

        scan = new Scanner(System.in);
        
        List <Pessoa> pessoas = new ArrayList<>(); 

        Controle dir = Controle.ENCERRAR;  

        if(dir == Controle.ENCERRAR) {

            System.out.println("ENCERRANDO");
          

        } else if(dir == Controle.CRIAR) {

            Pessoa pessoa = new Pessoa();

            System.out.println("\nCadastro\n");

            System.out.println("\nDigite o nome:");
            pessoa.setNome(scan.next());

            System.out.println("\nDigite a idade:");
            pessoa.setIdade(scan.nextInt());

            System.out.println("\nDigite a matricula:");
            pessoa.setMatricula(scan.nextInt());

            pessoas.add(pessoa);


             
          } else if(dir == Controle.MODIFICAR) {
             
            } else {
                
                
            }
    
   
        
        
           
        


            

        }

   
        
    }    

        

    


