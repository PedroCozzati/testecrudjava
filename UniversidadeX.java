public class UniversidadeX implements Escola {

    @Override
    public String endereco() {
        System.out.println("Rua X, numero 10");
        return endereco();

    }

    @Override
    public int salas() {
        System.out.println("Numero de salas: 50");
        return salas();
        
    }

    @Override
    public int professores() {
        System.out.println("Total de professores: 90");
        return professores();
        
    }

    @Override
    public int alunos() {
        System.out.println("Total de alunos:500");
        return alunos();
    }

        
 
}
