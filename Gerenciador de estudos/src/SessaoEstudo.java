import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.util.Scanner;

public class SessaoEstudo {
    private LocalDate data;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private String assunto;
    private Disciplina disciplina;

    public SessaoEstudo(String assunto, Disciplina disciplina) {


        this.data = LocalDate.now();
        this.horarioInicio = LocalTime.now();
        this.assunto = assunto;
        this.disciplina = disciplina;
    }

    public void finalizarSessao() {
        this.horarioFim = LocalTime.now();
        Duration duracao = Duration.between(
                horarioInicio,
                horarioFim);

        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;
        long segundos = duracao.getSeconds() % 60;

        System.out.println(
                "Tempo estudado: " + horas + "h " + minutos + "min " + segundos + "s"
        );


    }

    public void mostrarassunto() {
        System.out.printf("o assunto estudado foi: %s", this.assunto);
    }

}



