package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR("A desejar", new BigDecimal("0.03")),
    BOM("Bom", new BigDecimal("0.15")),
    OTIMO("Otimo", new BigDecimal("0.20"));

    private String descricao;
    private BigDecimal porcentagemDeAumento;

    Desempenho(String descricao, BigDecimal porcentagemDeAumento) {
        this.descricao = descricao;
        this.porcentagemDeAumento = porcentagemDeAumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPorcentagemDeAumento() {
        return porcentagemDeAumento;
    }
}
