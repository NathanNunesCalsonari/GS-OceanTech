package br.com.fiap.oceantech.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public class PlataformaDTO {

    private Long id;

    @NotBlank
    private String nomePlataforma;

    private Date dataInstalacao;

    private char statusPlataforma;

    private int quantidadeFuncionario;

    private String descricaoPlataforma;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePlataforma() {
        return nomePlataforma;
    }

    public void setNomePlataforma(String nomePlataforma) {
        this.nomePlataforma = nomePlataforma;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public char getStatusPlataforma() {
        return statusPlataforma;
    }

    public void setStatusPlataforma(char statusPlataforma) {
        this.statusPlataforma = statusPlataforma;
    }

    public int getQuantidadeFuncionario() {
        return quantidadeFuncionario;
    }

    public void setQuantidadeFuncionario(int quantidadeFuncionario) {
        this.quantidadeFuncionario = quantidadeFuncionario;
    }

    public String getDescricaoPlataforma() {
        return descricaoPlataforma;
    }

    public void setDescricaoPlataforma(String descricaoPlataforma) {
        this.descricaoPlataforma = descricaoPlataforma;
    }
}
