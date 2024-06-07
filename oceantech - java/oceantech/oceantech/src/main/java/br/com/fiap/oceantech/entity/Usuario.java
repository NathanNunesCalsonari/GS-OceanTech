package br.com.fiap.oceantech.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_OCT_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NM_USUARIO", nullable = false)
    private String nomeUsuario;

    @Column(name = "NR_SENHA", nullable = false)
    private String senha;

    @Column(name = "NM_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "DT_CRIACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    public Usuario(String nomeUsuario, String senha, String email, Date dataCriacao) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.email = email;
        this.dataCriacao = dataCriacao;
    }

    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
