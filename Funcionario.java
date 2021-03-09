import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa {

    private static Scanner s;
    private static Scanner a;

    public static void main(String[] args) {


        s = new Scanner(System.in);
        ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();    

        a = new Scanner(System.in);

        fim = a.nextInt();
        
        while (fim != 9999){

            for(int i=0; i < 1; i++){
                
                Pessoa pessoa = new Pessoa();
                System.out.println("\nDigite o nome:");
                pessoa.nome = s.next();

                System.out.println("\nDigite a idade:");
                pessoa.idade = s.nextInt();

                System.out.println("\nDigite a matricula:");
                pessoa.idade = s.nextInt();

                listaPessoa.add(pessoa);

            }
            
        }

        System.out.println(listaPessoa);
    }

}
