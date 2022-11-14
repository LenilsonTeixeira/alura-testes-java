import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {

    @Test
    void deveCalcularBonusComValorAcimaDeMil() {
        Funcionario funcionario = new Funcionario("Lenilson", LocalDate.now(), new BigDecimal("16000"));
        BonusService bonusService = new BonusService();
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario)).getMessage();
        Assertions.assertEquals("Funcionário com salário maior do que R$10000 nao pode receber bonus!", message);
    }

    @Test
    void deveCalcularBonusComValorAbaixoDeMil() {
        Funcionario funcionario = new Funcionario("Lenilson", LocalDate.now(), new BigDecimal("1200"));
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(funcionario);
        Assertions.assertEquals(new BigDecimal("120.0"), bonus);
    }

    @Test
    void deveCalcularBonusComValorIgualMil() {
        Funcionario funcionario = new Funcionario("Lenilson", LocalDate.now(), new BigDecimal("10000"));
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(funcionario);
        Assertions.assertEquals(new BigDecimal("1000.0"), bonus);
    }
}
