package br.com.fiap.oceantech.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_OCT_PLATAFORMA")
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLATAFORMA")
    private Long id;

    @Column(name = "NM_PLATAFORMA", nullable = false)
    private String nomePlataforma;

    @Column(name = "DT_INSTALACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInstalacao;

    @Column(name = "ST_PLATAFORMA", nullable = false)
    private char statusPlataforma;

    @Column(name = "QT_FUNCIONARIO")
    private int quantidadeFuncionario;

    @Column(name = "DS_PLATAFORMA")
    private String descricaoPlataforma;

    // Construtores, getters e setters

    public Plataforma() {
    }

    public Plataforma(Long id, String nomePlataforma, Date dataInstalacao, char statusPlataforma, int quantidadeFuncionario, String descricaoPlataforma) {
        this.id = id;
        this.nomePlataforma = nomePlataforma;
        this.dataInstalacao = dataInstalacao;
        this.statusPlataforma = statusPlataforma;
        this.quantidadeFuncionario = quantidadeFuncionario;
        this.descricaoPlataforma = descricaoPlataforma;
    }

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
