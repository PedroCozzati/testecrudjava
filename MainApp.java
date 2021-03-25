public class MainApp {

    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.TreeMap;
    import java.util.List;
    import java.util.Map;
    public static final String ERRO = "\nErro\n";
    public static Scanner scan;

    public static void main(String[] args) {
       
        scan = new Scanner(System.in);
        Map <String, Integer> chaveMatricula = new TreeMap <>();
        Map <String, Integer> chaveCertificado = new TreeMap <>();
        List <Aluno> alunos = new ArrayList<>(); 
        List <Professor> professores = new ArrayList<>();

        System.out.println("\n---------Sistema de cadastro para escolas, universidades e cursos---------\n");
        System.out.println("\n---------Cadastro---------\n\ndigite \"criar\" para um novo cadastro \"encerrar\" para encerrar o programa\nR:");
        Controle controle = Controle.valueOf(scan.next().toUpperCase()); 
        
        if(Programa.isVerificarControleValido(controle)) {
            System.out.println(ERRO);
            System.exit(0);
        }

            while(Programa.isVerificarControleCriar(controle)) {
                Aluno aluno = new Aluno();
                Professor professor = new Professor();
                
                
                
                System.out.println("\nCadastro\n");
                System.out.println("\nDigite o nome(minimo 3 caracteres, e começar com letra maiúscula):\nR:");
                aluno.setNome(scan.next());

                    if(Programa.isVerificarNomeInvalido(aluno)) {
                        System.out.println(ERRO);
                        System.exit(0);
                    }
                    else if(Programa.isVerificarNomeMinuscula(aluno)) {
                        System.out.println(ERRO);
                        System.exit(0);
                    }

                System.out.println("\nDigite a idade(entre 18 e 70 anos):\nR:");
                aluno.setIdade(scan.nextInt());

                    if(Programa.isVerificarIdadeNaoPermitida(aluno)) {
                        System.out.println(ERRO);
                        System.exit(0);
                    }
                
                System.out.println("\nA pessoa a ser cadastrada é aluno ou professor?");
                System.out.println("\nDigite ALUNO OU PROFESSOR:\nR:");
                Opcao opcao = Opcao.valueOf(scan.next().toUpperCase());
                
                if(opcao == Opcao.ALUNO){
                    System.out.println("\n---------Para qual instituição será feito o cadastro do aluno?---------\n");
                    opcao = Opcao.valueOf(scan.next().toUpperCase());
                    if(opcao == Opcao.UNIVERSIDADE){
                        System.out.println("\nDigite a matricula(entre 0 e 9999):\nR:");
                        aluno.setMatricula(scan.nextInt());

                        if(Programa.isVerificarMatriculaInvalida(aluno)) {
                            System.out.println(ERRO);
                            System.exit(0);
                        }
                    }
                alunos.add(aluno);
                
                chaveMatricula.put(aluno.getNome(),aluno.getMatricula());
                System.out.println("\nAluno cadastrado, digite \"criar\" para um novo cadastro,  \"alterar\" para alterar um cadastro, \"deletar\" para excluir um cadastro,  \"ver\" para ver a lista de alunos cadastrados e \"encerrar\" para encerrar o programa:\nR:");

                }
                else if(opcao == Opcao.PROFESSOR){

                    System.out.println("\n---------Para qual instituição será feito o cadastro do professor?---------\n");
                    opcao = Opcao.valueOf(scan.next().toUpperCase());

                    if(opcao == Opcao.UNIVERSIDADE){
                        professor.setNome(aluno.getNome());
                        professor.setIdade(aluno.getIdade());
                        System.out.println("\nDigite o ano do certificado:\nR:");
                        professor.setAnoCertificado(scan.nextInt());
                        professor.setId("FATEC");

                        if(professor.getAnoCertificado() > 2020 ) {
                            System.out.println(ERRO);
                            System.exit(0);
                        }
                        else if(professor.getAnoCertificado() < 1980){
                            System.out.println(ERRO);
                            System.exit(0);

                        }
                    }
                    else if(opcao == Opcao.ESCOLA){
                        professor.setNome(aluno.getNome());
                        System.out.println("\nDigite o ano do certificado:\nR:");
                        professor.setAnoCertificado(scan.nextInt());
                        professor.setId("ETEC");

                        if(professor.getAnoCertificado() > 2020 ) {
                            System.out.println(ERRO);
                            System.exit(0);
                        }
                        else if(professor.getAnoCertificado() < 1980){
                            System.out.println(ERRO);
                            System.exit(0);

                        }
                    }
                professores.add(professor);
                chaveCertificado.put(professor.getNome(),professor.getAnoCertificado());
                System.out.println("\nProfessor cadastrado, digite \"criar\" para um novo cadastro,  \"alterar\" para alterar um cadastro, \"deletar\" para excluir um cadastro,  \"ver\" para ver a lista de alunos cadastrados e \"encerrar\" para encerrar o programa:\nR:");

               }
                controle = Controle.valueOf(scan.next().toUpperCase());
                if(Programa.isVerificarControleVer(controle)){
                    System.out.print("\n-----Ver lista de professores ou alunos?\nDigite PROFESSOR OU ALUNO\n-----\n\n");
                    opcao = Opcao.valueOf(scan.next().toUpperCase());
                

                    
                    if (opcao == Opcao.PROFESSOR){
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print("\n"+professores+"\n\n");
                        System.out.println("digite \"criar\" para um novo cadastro, e \"encerrar\" para fechar o programa\n");
                        controle = Controle.valueOf(scan.next().toUpperCase());
                    }
                    else if (opcao ==Opcao.ALUNO){
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print("\n"+alunos+"\n\n");
                        System.out.println("digite \"criar\" para um novo cadastro, e \"encerrar\" para fechar o programa\n");
                        controle = Controle.valueOf(scan.next().toUpperCase());
                    }
                }      

                else if (Programa.isVerificarControleEncerrar(controle)) {

                    System.out.println("\nEncerrando...\n");    
                    System.exit(0);
                }

                while(Programa.isVerificarControleAlterar(controle)){
                    System.out.print("\n-----Ver lista de professores ou alunos?\nDigite PROFESSOR OU ALUNO\n-----\n\n");
                    opcao = Opcao.valueOf(scan.next().toUpperCase());
                    
                    System.out.print("\n------Ver lista-----\n\n");

                    if (opcao ==Opcao.ALUNO){
                        System.out.print(alunos+"\n"+chaveMatricula.entrySet()+"\n\n");
                        System.out.print("Qual matricula deseja alterar?\n");
                        chaveMatricula.put(aluno.getNome(),scan.nextInt());
                        
                        System.out.println("Qual a nova matricula?:  ");
                        aluno.setMatricula(scan.nextInt());
                        chaveMatricula.put(aluno.getNome(),aluno.getMatricula()) ;
                    
                        System.out.print(chaveMatricula.entrySet()+"\n\n");
                        System.out.print(alunos+"\n"+chaveMatricula.entrySet()+"\n\n");
                        System.out.println("digite \"criar\" para um novo cadastro, e \"encerrar\" para fechar o programa\n");
                    }
                    else if (opcao == Opcao.PROFESSOR){

                        System.out.print(professores+"\n"+chaveCertificado.entrySet()+"\n\n");
                        System.out.print("Qual certificado  deseja alterar?\n");
                        chaveCertificado.put(professor.getNome(),scan.nextInt());
                        
                        System.out.println("Qual o novao certificado?:  ");
                        professor.setAnoCertificado(scan.nextInt());
                        chaveCertificado.put(professor.getNome(),professor.getAnoCertificado()) ;
                    
                        System.out.print(chaveCertificado.entrySet()+"\n\n");
                        System.out.print(professores+"\n"+chaveCertificado.entrySet()+"\n\n");
                        System.out.println("digite \"criar\" para um novo cadastro, e \"encerrar\" para fechar o programa\n");
                    }
                        controle = Controle.valueOf(scan.next().toUpperCase());

                    if (Programa.isVerificarControleEncerrar(controle)){
                        System.exit(0);
                    }
                    else if(Programa.isVerificarControleCriar(controle)){                            
                        Programa.isVerificarControleCriar(controle);
                    }
                    else{
                        System.out.println(ERRO);
                        System.exit(0);
                    }
                }
                if (Programa.isVerificarControleDeletar(controle)) {
                    System.out.print("\nDe qual lista você quer deletar?\nDigite ALUNO OU PROFESSOR\n\n");
                    opcao = Opcao.valueOf(scan.next().toUpperCase());

                    if (opcao ==Opcao.ALUNO){
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print(professores+"\n\n");
                        System.out.print("\nQual cadastro você quer deletar(contagem inicia no 0)\n\n");
                        alunos.remove(alunos.get(scan.nextInt()));
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print(alunos+"\n\n");

                    }
                    else if (opcao == Opcao.PROFESSOR){
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print(professores+"\n\n");
                        System.out.print("\nQual cadastro você quer deletar(contagem inicia no 0)\n\n");
                        professores.remove(professores.get(scan.nextInt()));
                        System.out.print("\n------Ver lista-----\n\n");
                        System.out.print(professores+"\n\n");
                    }
                }
            
        }       
    }
  



    

