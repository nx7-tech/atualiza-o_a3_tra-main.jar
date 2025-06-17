package org.exemple.dao.model;

public enum Servico {
    CABELO_SOCIAL(1, 130.0),
    CABELO_NOIVA(2, 400.0),
    MAQUIAGEM_SOCIAL(3, 150.0),
    MAQUIAGEM_NOIVA(4, 400.0),
    VESTIDO_SOCIAL(5, 200.0),
    VESTIDO_NOIVA(6, 3500.0);

    private final int id;
    private final double valorServico;

    Servico(int id, double valorServico) {
        this.id = id;
        this.valorServico = valorServico;
    }

    public int getId() {
        return id;
    }

}

// VALOR E TIPO DO SERVIÇO