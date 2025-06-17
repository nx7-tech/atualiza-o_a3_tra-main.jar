package org.exemple.dao.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {
    private int id_Agendamento;
    private LocalDate data;
    private LocalTime hora;
    private int cliente;
    private int servico ;

    public Agendamento(LocalDate data, LocalTime hora, int cliente, int servico) {
        this.data = data;
        this.hora = hora;
        this.cliente = cliente;
        this.servico = servico;
    }

    public int getId_Agendamento() {
        return id_Agendamento;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public int getCliente() {
        return cliente;
    }

    public int getServico() {
        return servico;
    }
    }

//CLASS-E PRINCIPAL ENTRE ASPAS