

public class ComputadorBuilder {

    private Computador computador;

    public ComputadorBuilder() {
        computador = new Computador();
    }

    public Computador build() {
        if (computador.getProcessador() == null ||
                computador.getProcessador().trim().isEmpty()) {
            throw new IllegalArgumentException("Processador inválido");
        }

        if (computador.getMemoriaRam() <= 0) {
            throw new IllegalArgumentException("Memória RAM inválida");
        }

        if (computador.getArmazenamento() <= 0) {
            throw new IllegalArgumentException("Armazenamento inválido");
        }

        return computador;
    }

    public ComputadorBuilder setProcessador(String processador) {
        computador.setProcessador(processador);
        return this;
    }

    public ComputadorBuilder setMemoriaRam(int memoriaRam) {
        computador.setMemoriaRam(memoriaRam);
        return this;
    }

    public ComputadorBuilder setArmazenamento(int armazenamento) {
        computador.setArmazenamento(armazenamento);
        return this;
    }

    public ComputadorBuilder setPlacaVideo(String placaVideo) {
        computador.setPlacaVideo(placaVideo);
        return this;
    }
}