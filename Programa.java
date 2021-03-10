import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

    private static Scanner s;
    public static void main(String[] args) {

        s = new Scanner(System.in);
        ArrayList <Pessoa> pessoas = new ArrayList<>();    
        Controle obj1 = new Controle(0, 0, 0, 0);
        obj1.setContinuar(1);

        
        while (obj1.getContinuar() == 1){

            
            
            Pessoa pessoa = new Pessoa();

            System.out.println("\nCadastro\n");

            System.out.println("\nDigite o nome:");
            pessoa.nome = s.next();

            System.out.println("\nDigite a idade:");
            pessoa.idade = s.nextInt();

            System.out.println("\nDigite a matricula:");
            pessoa.matricula = s.nextInt();

            pessoas.add(pessoa);

            System.out.println("\nDeseja encerrar? (digite 1 para encerrar, 0 para continuar):");
            obj1.setFim(s.nextInt());
            if (obj1.getFim() == 1){
                break;

            }
            
        }    

        System.out.print("Lista de pessoas cadastradas\n"+ pessoas);

    }  
}

