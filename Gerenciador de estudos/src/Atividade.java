public abstract class Atividade {
        private String titulo;
        private double notaMaxima;
        private double notaObtida;

        public Atividade(String titulo, double notaMaxima) {
            this.titulo = titulo;
            this.notaMaxima = notaMaxima;
            this.notaObtida = 0;
        }

        public void setNotaObtida(double nota) {
            if (nota >= 0 && nota <= notaMaxima) {
                this.notaObtida = nota;
            }
        }

        public double getNotaObtida() {
            return notaObtida;
        }

        public String getTitulo() {
            return titulo;
        }

        public double getNotaMaxima() {
            return notaMaxima;
        }
}


