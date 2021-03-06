package br.com.systemdelivery.systemdelivery.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO", nullable = false)
    private Long codigoUsuario;
    
    @Size(min = 10, max = 100)
    @Column(name = "NM_USUARIO", nullable = false)
    private String nomeUsuario;
    
    @Size(min = 14, max = 14)
    @Column(name = "CP_USUARIO", nullable = false, unique = false)
    private String cpfUsuario;
    
    @Email
    @Size(min = 3, max = 100)
    @Column(name = "EM_USUARIO", nullable = false, unique = false)
    private String emailUsuario;
    
    @Column(name = "AC_USUARIO", nullable = false)
    private Boolean acessoUsuario;
    
    @Column(name = "DT_USUARIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Boolean getAcessoUsuario() {
        return acessoUsuario;
    }

    public void setAcessoUsuario(Boolean acessoUsuario) {
        this.acessoUsuario = acessoUsuario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
