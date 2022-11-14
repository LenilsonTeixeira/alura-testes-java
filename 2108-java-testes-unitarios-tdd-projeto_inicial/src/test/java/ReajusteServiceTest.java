import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class ReajusteServiceTest {

    private Funcionario funcionario;
    private ReajusteService reajusteService;

    @BeforeEach
    public void setup() {
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
        this.reajusteService = new ReajusteService();
    }

    @Test
    void deveCalcularReajusteAnualParaFuncionarioComDesempenhoClassificadoComoADesejar() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }

    @Test
    void deveCalcularReajusteAnualParaFuncionarioComDesempenhoClassificadoComoBom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void deveCalcularReajusteAnualParaFuncionarioComDesempenhoClassificadoComoOtimo() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
