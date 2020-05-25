package br.com.tidicas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe de entidade Curriculo
 * 
 * @author Evaldo Junior
 */
@Entity
@Table(name="curriculo")
public class Curriculo implements Serializable {

	private static final long serialVersionUID = -6043379033391900736L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)   
	@Column(name = "codigo") 
	private Integer codigo;
	@Column(name = "nome") 
    private String nome;
	@Column(name = "email") 
    private String email;
	@Column(name = "sexo") 
    private String sexo;
	@Column(name = "estadocivil") 
    private String estadoCivil;
	@Column(name = "cpf") 
    private String cpf;
    @Temporal(TemporalType.DATE)
    @Column(name="nascimento") 
    private Date nascimento;
    @Column(name = "empregado") 
    private String empregado;
    @Column(name = "telefoneDDD") 
    private Integer telefoneDDD;
    @Column(name = "telefone") 
    private Integer telefone;
    @Column(name = "recado")
    private String recado;
    @Column(name = "celularDDD")
    private Integer celularDDD;
    @Column(name = "celular")
    private Integer celular;
    @Column(name = "homePage")
    private String homePage;
    @Column(name = "endereco") 
    private String endereco;
    @Column(name = "numero") 
    private Integer numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro") 
    private String bairro;
    @Column(name = "cep") 
    private Integer cep;
    @Column(name = "estado") 
    private String estado;
    @Column(name = "cidade") 
    private String cidade;
    @Column(name = "desejoTrabalharCidade")
    private String desejoTrabalharCidade;
    @Column(name = "ramo")
    private String ramo;
    @Column(name = "area")
    private String area;
    @Column(name = "nivel")
    private String nivel;
    @Column(name = "pretensao")
    private Double pretensao;
    @Column(name = "palavrachave")
    private String palavraChave;
    @Column(name = "objetivo")
    private String objetivo;
    @Column(name = "minicurriculo")
    private String minicurriculo;
    @Column(name = "especializacoes")
    private String especializacoes;
    @Column(name = "formacaograu")
    private String formacaoGrau;
    @Column(name = "formacaocurso")
    private String formacaoCurso;
    @Temporal(TemporalType.DATE)
    @Column(name = "formacaodatainiciomesano")
    private Date formacaoDataInicioMesAno;
    @Temporal(TemporalType.DATE)
    @Column(name = "formacaodatasaidamesano")
    private Date formacaoDataSaidaMesAno;
    @Column(name = "formacaoinstituicao")
    private String formacaoInstituicao;
    
    @OneToMany(mappedBy="curriculo", cascade={CascadeType.ALL,CascadeType.REMOVE})    
    private Collection<Idioma> idiomas=new ArrayList<Idioma>();
    
    @OneToMany(mappedBy="curriculo", cascade={CascadeType.ALL,CascadeType.REMOVE})     
    private Collection<Experiencia> experiencias= new ArrayList<Experiencia>();
    
    @JoinColumn(name="login_id",referencedColumnName="codigo")
	@OneToOne(cascade = CascadeType.ALL)
    private Login login=new Login();
    
    /** Creates a new instance of Curriculo */
    public Curriculo() {
    }

    /**
     * Cria uma nova inst�ncia de Curriculo com os valores especificados.
     * @param codigo o codigo do Curriculo
     */
    public Curriculo(Integer codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Define o codigo deste Curriculo.
     * @return o codigo
     */
    
    public Integer getCodigo() {
        return this.codigo;
    }

    /**
     * Define o codigo deste Curriculo para o valor especificado.
     * @param codigo o novo codigo
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Define o nome deste Curriculo.
     * @return o nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Define o nome deste Curriculo para o valor especificado.
     * @param nome o novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o email deste Curriculo.
     * @return o email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Define o email deste Curriculo para o valor especificado.
     * @param email o novo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Define o sexo deste Curriculo.
     * @return o sexo
     */
    public String getSexo() {
        return this.sexo;
    }

    /**
     * Define o sexo deste Curriculo para o valor especificado.
     * @param sexo o novo sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Define o estadoCivil deste Curriculo.
     * @return o estadoCivil
     */
    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    /**
     * Define o estadoCivil deste Curriculo para o valor especificado.
     * @param estadoCivil o novo estadoCivil
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * Define o cpf deste Curriculo.
     * @return o cpf
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Define o cpf deste Curriculo para o valor especificado.
     * @param cpf o novo cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
   /**
     * Define o empregado deste Curriculo.
     * @return o empregado
     */
    public String getEmpregado() {
        return this.empregado;
    }

    /**
     * Define o empregado deste Curriculo para o valor especificado.
     * @param empregado o novo empregado
     */
    public void setEmpregado(String empregado) {
        this.empregado = empregado;
    }

    /**
     * Define o telefoneDDD deste Curriculo.
     * @return o telefoneDDD
     */
    public Integer getTelefoneDDD() {
        return this.telefoneDDD;
    }

    /**
     * Define o telefoneDDD deste Curriculo para o valor especificado.
     * @param telefoneDDD o novo telefoneDDD
     */
    public void setTelefoneDDD(Integer telefoneDDD) {
        this.telefoneDDD = telefoneDDD;
    }

    /**
     * Define o telefone deste Curriculo.
     * @return o telefone
     */
    public Integer getTelefone() {
        return this.telefone;
    }

    /**
     * Define o telefone deste Curriculo para o valor especificado.
     * @param telefone o novo telefone
     */
    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    /**
     * Define o recado deste Curriculo.
     * @return o recado
     */
    public String getRecado() {
        return this.recado;
    }

    /**
     * Define o recado deste Curriculo para o valor especificado.
     * @param recado o novo recado
     */
    public void setRecado(String recado) {
        this.recado = recado;
    }

    /**
     * Define o celularDDD deste Curriculo.
     * @return o celularDDD
     */
    public Integer getCelularDDD() {
        return this.celularDDD;
    }

    /**
     * Define o celularDDD deste Curriculo para o valor especificado.
     * @param celularDDD o novo celularDDD
     */
    public void setCelularDDD(Integer celularDDD) {
        this.celularDDD = celularDDD;
    }

    /**
     * Define o celular deste Curriculo.
     * @return o celular
     */
    public Integer getCelular() {
        return this.celular;
    }

    /**
     * Define o celular deste Curriculo para o valor especificado.
     * @param celular o novo celular
     */
    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    /**
     * Define o homePage deste Curriculo.
     * @return o homePage
     */
    public String getHomePage() {
        return this.homePage;
    }

    /**
     * Define o homePage deste Curriculo para o valor especificado.
     * @param homePage o novo homePage
     */
    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    /**
     * Define o endereco deste Curriculo.
     * @return o endereco
     */
    public String getEndereco() {
        return this.endereco;
    }

    /**
     * Define o endereco deste Curriculo para o valor especificado.
     * @param endereco o novo endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Define o numero deste Curriculo.
     * @return o numero
     */
    public Integer getNumero() {
        return this.numero;
    }

    /**
     * Define o numero deste Curriculo para o valor especificado.
     * @param numero o novo numero
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Define o complemento deste Curriculo.
     * @return o complemento
     */
    public String getComplemento() {
        return this.complemento;
    }

    /**
     * Define o complemento deste Curriculo para o valor especificado.
     * @param complemento o novo complemento
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Define o bairro deste Curriculo.
     * @return o bairro
     */
    public String getBairro() {
        return this.bairro;
    }

    /**
     * Define o bairro deste Curriculo para o valor especificado.
     * @param bairro o novo bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Define o cep1 deste Curriculo.
     * @return o cep1
     */
    public Integer getCep() {
        return this.cep;
    }

    /**
     * Define o cep1 deste Curriculo para o valor especificado.
     * @param cep1 o novo cep1
     */
    public void setCep(Integer cep) {
        this.cep = cep;
    }

    /**
     * Define o estado deste Curriculo.
     * @return o estado
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * Define o estado deste Curriculo para o valor especificado.
     * @param estado o novo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Define o cidade deste Curriculo.
     * @return o cidade
     */
    public String getCidade() {
        return this.cidade;
    }

    /**
     * Define o cidade deste Curriculo para o valor especificado.
     * @param cidade o novo cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Define o desejoTrabalharCidade deste Curriculo.
     * @return o desejoTrabalharCidade
     */
    public String getDesejoTrabalharCidade() {
        return this.desejoTrabalharCidade;
    }

    /**
     * Define o desejoTrabalharCidade deste Curriculo para o valor especificado.
     * @param desejoTrabalharCidade o novo desejoTrabalharCidade
     */
    public void setDesejoTrabalharCidade(String desejoTrabalharCidade) {
        this.desejoTrabalharCidade = desejoTrabalharCidade;
    }

    /**
     * Define o ramo deste Curriculo.
     * @return o ramo
     */
    public String getRamo() {
        return this.ramo;
    }

    /**
     * Define o ramo deste Curriculo para o valor especificado.
     * @param ramo o novo ramo
     */
    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    /**
     * Define o area deste Curriculo.
     * @return o area
     */
    public String getArea() {
        return this.area;
    }

    /**
     * Define o area deste Curriculo para o valor especificado.
     * @param area o novo area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Define o nivel deste Curriculo.
     * @return o nivel
     */
    public String getNivel() {
        return this.nivel;
    }

    /**
     * Define o nivel deste Curriculo para o valor especificado.
     * @param nivel o novo nivel
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * Define o pretensao deste Curriculo.
     * @return o pretensao
     */
    public Double getPretensao() {
        return this.pretensao;
    }

    /**
     * Define o pretensao deste Curriculo para o valor especificado.
     * @param pretensao o novo pretensao
     */
    public void setPretensao(Double pretensao) {
        this.pretensao = pretensao;
    }

    /**
     * Define o palavraChave deste Curriculo.
     * @return o palavraChave
     */
    public String getPalavraChave() {
        return this.palavraChave;
    }

    /**
     * Define o palavraChave deste Curriculo para o valor especificado.
     * @param palavraChave o novo palavraChave
     */
    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    /**
     * Define o objetivo deste Curriculo.
     * @return o objetivo
     */
    public String getObjetivo() {
        return this.objetivo;
    }

    /**
     * Define o objetivo deste Curriculo para o valor especificado.
     * @param objetivo o novo objetivo
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * Define o minicurriculo deste Curriculo.
     * @return o minicurriculo
     */
    public String getMinicurriculo() {
        return this.minicurriculo;
    }

    /**
     * Define o minicurriculo deste Curriculo para o valor especificado.
     * @param minicurriculo o novo minicurriculo
     */
    public void setMinicurriculo(String minicurriculo) {
        this.minicurriculo = minicurriculo;
    }

    /**
     * Define o especializacoes deste Curriculo.
     * @return o especializacoes
     */
    public String getEspecializacoes() {
        return this.especializacoes;
    }

    /**
     * Define o especializacoes deste Curriculo para o valor especificado.
     * @param especializacoes o novo especializacoes
     */
    public void setEspecializacoes(String especializacoes) {
        this.especializacoes = especializacoes;
    }

    /**
     * Define o formacaoGrau deste Curriculo.
     * @return o formacaoGrau
     */
    public String getFormacaoGrau() {
        return this.formacaoGrau;
    }

    /**
     * Define o formacaoGrau deste Curriculo para o valor especificado.
     * @param formacaoGrau o novo formacaoGrau
     */
    public void setFormacaoGrau(String formacaoGrau) {
        this.formacaoGrau = formacaoGrau;
    }

    /**
     * Define o formacaoCurso deste Curriculo.
     * @return o formacaoCurso
     */
    public String getFormacaoCurso() {
        return this.formacaoCurso;
    }

    /**
     * Define o formacaoCurso deste Curriculo para o valor especificado.
     * @param formacaoCurso o novo formacaoCurso
     */
    public void setFormacaoCurso(String formacaoCurso) {
        this.formacaoCurso = formacaoCurso;
    }
    
    /**
     * Define o formacaoInstituicao deste Curriculo.
     * @return o formacaoInstituicao
     */
    public String getFormacaoInstituicao() {
        return this.formacaoInstituicao;
    }

    /**
     * Define o formacaoInstituicao deste Curriculo para o valor especificado.
     * @param formacaoInstituicao o novo formacaoInstituicao
     */
    public void setFormacaoInstituicao(String formacaoInstituicao) {
        this.formacaoInstituicao = formacaoInstituicao;
    }

            
    
    /**
     * Retorna um valor de c�digo hash para o objeto.  Esta implementa��o computa
     * um valor de c�digo hash baseado nos campos id deste objeto.
     * @return um valor de c�digo hash para este objeto.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    /**
     * Determina se outro objeto � igual a este Curriculo.  O resultado �
     * <code>true</code> se e somente se o argumento n�o for nulo e for um objeto Curriculo o qual
     * tem o mesmo valor para o campo id como este objeto.
     * @param object o objeto de refer�ncia com o qual comparar
     * @return <code>true</code> se este objeto � o mesmo como o argumento;
     * <code>false</code> caso contr�rio.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curriculo)) {
            return false;
        }
        Curriculo other = (Curriculo)object;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) return false;
        return true;
    }

    /**
     * Retorna uma representa��o literal deste objeto.  Esta implementa��o cria
     * uma representa��o baseada nos campos id.
     * @return uma representa��o literal deste objeto.
     */
    @Override
    public String toString() {
        return "model.Curriculo[codigo=" + codigo + "]";
    }
    
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Date getFormacaoDataInicioMesAno() {
		return formacaoDataInicioMesAno;
	}

	public void setFormacaoDataInicioMesAno(Date formacaoDataInicioMesAno) {
		this.formacaoDataInicioMesAno = formacaoDataInicioMesAno;
	}

	public Date getFormacaoDataSaidaMesAno() {
		return formacaoDataSaidaMesAno;
	}

	public void setFormacaoDataSaidaMesAno(Date formacaoDataSaidaMesAno) {
		this.formacaoDataSaidaMesAno = formacaoDataSaidaMesAno;
	}

	public Collection<Experiencia> getExperiencias() {
		return experiencias;
	}

	public Collection<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(Collection<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public void setExperiencias(Collection<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}