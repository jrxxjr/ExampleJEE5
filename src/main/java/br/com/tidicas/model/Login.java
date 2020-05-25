package br.com.tidicas.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe de entidade Idiomas
 * 
 * @author Evaldo Junior
 */
@Entity
@Table(name="login")
public class Login implements Serializable {
	
	private static final long serialVersionUID = -574108251201088916L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name = "codigo") 
	private Integer codigo;
	@Column(name = "senha") 
    private String senha;
	@Column(name = "senhaanterior") 
    private String senhaAnterior;	
	@Column(name = "dicasenha")
    private String dicaSenha;
	
    /** Creates a new instance of Idiomas */
    public Login() {
    }

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaAnterior() {
		return senhaAnterior;
	}

	public void setSenhaAnterior(String senhaAnterior) {
		this.senhaAnterior = senhaAnterior;
	}
	
	public String getDicaSenha() {
		return dicaSenha;
	}

	public void setDicaSenha(String dicaSenha) {
		this.dicaSenha = dicaSenha;
	}
        
}