import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private List<Curso> cursos;

    public Aluno(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
        this.cursos = new ArrayList<>();
    }

    public void adicionarCurso(Curso curso) {
        if (curso != null) {
            this.cursos.add(curso);
        }
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeCursos() {
        return cursos.size();
    }
}