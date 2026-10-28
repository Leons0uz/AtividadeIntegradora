final class Configuracao {
    private static final Configuracao INSTANCIA = new Configuracao();
    private final String nome = "Sistema Acadêmico";
    
    private Configuracao() {}
    
    public static Configuracao getInstancia() { 
        return INSTANCIA; 
    }
    
    public String getNome() { 
        return nome; 
    }
}

public class Main {
    public static void main(String[] args) {
        // Exibindo o nome do sistema via Singleton
        System.out.println(Configuracao.getInstancia().getNome());

        // Criando o aluno e o curso
        Aluno aluno = new Aluno("Ana");
        Curso curso = new Curso("Java", 200.0);

        // Configurando o serviço de matrícula (Strategy + Adapter + Observer)
        ServicoMatricula servico = new ServicoMatricula(
            new DescontoEstudante(), 
            new AdaptadorPagamento(new SistemaLegado())
        );

        servico.inscrever(new AvisoEmail());
        servico.inscrever(new Auditoria());

        // Usando a Facade (Fachada) com Factory Method para emitir o comprovante
        FachadaAcademica fachada = new FachadaAcademica(servico, new CriadorTexto());

        System.out.println(fachada.matricularEEmitir(aluno, curso));
        System.out.println("Cursos do aluno: " + aluno.getQuantidadeCursos());
    }
}