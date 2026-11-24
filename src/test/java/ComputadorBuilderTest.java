

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputadorBuilderTest {

    @Test
    void deveRetornarComputadorValido() {
        Computador computador = new ComputadorBuilder()
                .setProcessador("Intel Core i5")
                .setMemoriaRam(16)
                .setArmazenamento(512)
                .setPlacaVideo("RTX 3050")
                .build();

        assertEquals("Intel Core i5", computador.getProcessador());
        assertEquals(16, computador.getMemoriaRam());
        assertEquals(512, computador.getArmazenamento());
        assertEquals("RTX 3050", computador.getPlacaVideo());
    }

    @Test
    void deveRetornarComputadorSemPlacaVideo() {
        Computador computador = new ComputadorBuilder()
                .setProcessador("Intel Core i7")
                .setMemoriaRam(16)
                .setArmazenamento(256)
                .build();

        assertNull(computador.getPlacaVideo());
    }

    @Test
    void deveRetornarExcecaoProcessadorInvalido() {
        try {
            new ComputadorBuilder()
                    .setMemoriaRam(16)
                    .setArmazenamento(512)
                    .build();

            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Processador inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoMemoriaRamInvalida() {
        try {
            new ComputadorBuilder()
                    .setProcessador("Intel Core i5")
                    .setMemoriaRam(-8)
                    .setArmazenamento(512)
                    .build();

            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Memória RAM inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoArmazenamentoInvalido() {
        try {
            new ComputadorBuilder()
                    .setProcessador("Intel Core i5")
                    .setMemoriaRam(16)
                    .setArmazenamento(0)
                    .build();

            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Armazenamento inválido", e.getMessage());
        }
    }
}