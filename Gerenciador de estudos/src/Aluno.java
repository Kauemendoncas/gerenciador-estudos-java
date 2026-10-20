
import java.util.ArrayList;
import java.util.List;

public class Aluno {

        private String nome;
        private String matricula;
        private String email;
        private String curso;
        private int semestre;

        private List<Disciplina> disciplinas;


    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;

        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }
        }
        public void listarDisciplinas() {
            for (Disciplina disciplina : disciplinas) {
                System.out.println(disciplina.getNome());
            }
        }

    public void listarMedias() {
        for (Disciplina disciplina : disciplinas) {
            System.out.println("Disciplina: " + disciplina.getNome());
            System.out.println("Média: " + disciplina.calcularMedia());
        }
    }

}
