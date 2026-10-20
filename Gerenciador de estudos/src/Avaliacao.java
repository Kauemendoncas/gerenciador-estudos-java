import java.util.ArrayList;
import java.util.List;

public class Avaliacao {

    private TipoAvaliacao tipo;
    private List<Atividade> atividades;

    public Avaliacao(TipoAvaliacao tipo) {
        this.tipo = tipo;
        this.atividades = new ArrayList<>();
    }

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public void removerAtividade(Atividade atividade) {
        atividades.remove(atividade);
    }

    public double calcularNota() {
        double soma = 0;

        for (Atividade atividade : atividades) {
            soma += atividade.getNotaObtida();
        }

        return soma;
    }

    public TipoAvaliacao getTipo() {
        return tipo;
    }

    public List<Atividade> getAtividades() {
        return List.copyOf(atividades);
    }
}
