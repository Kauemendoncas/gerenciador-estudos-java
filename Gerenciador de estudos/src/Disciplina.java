import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Disciplina {
    private String codigo;
    private String nome;
    private String professor;
    private String turno;
    private int semestre;


    private Set<Disciplina> preRequisito;
    private StatusDisciplina status;
    private List<Avaliacao> avaliacoes;

    public Disciplina(String codigo, String nome, String professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.professor = professor;
        this.status = StatusDisciplina.EM_ANDAMENTO;

        this.preRequisito = new HashSet<>();

        this.avaliacoes = new ArrayList<>();
    }



    public void adicionarPreRequisito(Disciplina disciplina) {
        preRequisito.add(disciplina);
    }

    public void removerPreRequisito(Disciplina disciplina) {
        preRequisito.remove(disciplina);
    }

    public boolean possuiPreRequisito(Disciplina disciplina) {
        return preRequisito.contains(disciplina);
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getProfessor() {
        return professor;
    }

    public StatusDisciplina getStatus() {
        return status;
    }

    public Set<Disciplina> getPreRequisitos() {
        return Set.copyOf(preRequisito);
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {

        if (avaliacoes.size() >= 3) {
            System.out.println("Todas as avaliações já foram cadastradas!");
            return;
        }

        TipoAvaliacao[] ordem = {
                TipoAvaliacao.AV1,
                TipoAvaliacao.AV2,
                TipoAvaliacao.AV3
        };

        TipoAvaliacao esperado = ordem[avaliacoes.size()];

        if (avaliacao.getTipo() != esperado) {
            System.out.println("A próxima avaliação deve ser " + esperado);
            return;
        }

        avaliacoes.add(avaliacao);
    }

    public void removerAvaliacao(Avaliacao avaliacao) {
        avaliacoes.remove(avaliacao);
    }

    public double calcularMedia() {

        if (avaliacoes.size() != 3) {
            throw new IllegalStateException(
                    "É necessário cadastrar as três avaliações!"
            );
        }

        double soma = 0;

        for (Avaliacao avaliacao : avaliacoes) {
            soma += avaliacao.calcularNota();
        }

        return soma / 3;
    }

    public void verificarAprovacao() {

        if (avaliacoes.size() != 3) {
            this.status = StatusDisciplina.EM_ANDAMENTO;
            return;
        }

        double media = calcularMedia();

        if (media >= 5) {
            this.status = StatusDisciplina.APROVADO;
        } else {
            this.status = StatusDisciplina.REPROVADO;
        }
    }


    public List<Avaliacao> getAvaliacoes() {
        return List.copyOf(avaliacoes);
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Professor: " + getProfessor());
        System.out.println("Status: " + getStatus());
        System.out.println("Pré requisitos: " + getPreRequisitos());
    }



}







