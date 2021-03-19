public class UniversidadeX implements Escola {

    @Override
    public String getEndereco() {
        System.out.println("Rua X, numero 10");
        return getEndereco();

    }

    @Override
    public int getSalas() {
        System.out.println("Numero de salas: 50");
        return getSalas();
        
    }

    @Override
    public int getProfessores() {
        System.out.println("Total de professores: 90");
        return getProfessores();
        
    }

    @Override
    public int getAlunos() {
        System.out.println("Total de alunos:500");
        return getAlunos();
    }

        
 
}
