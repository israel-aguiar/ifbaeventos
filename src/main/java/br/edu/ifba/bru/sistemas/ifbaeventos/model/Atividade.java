package br.edu.ifba.bru.sistemas.ifbaeventos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ATIVIDADE")
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 100)
	private String titulo;
	
	@Size(max = 10)
	private String codigo;
	
	@Size(max = 30)
	private String areaAtividade;
	
	@Column(name = "requisito_atividade", columnDefinition = "TEXT")
	private String requisitoAtividade;
	
	@Min(0)
	private int ch;
	
	@Min(0)
	@Column(name = "vagas_total")
	private int vagasTotal;
	
	@Transient
	private int vagasDisponiveis;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Size(max = 11)
	private String turno;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name = "tipo_atividade_id")
	private TipoAtividade tipoAtividade;
	
	@ManyToOne
	@JoinColumn(name = "ministrante_id")
	private Ministrante ministrante;

	public Atividade() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAreaAtividade() {
		return areaAtividade;
	}

	public void setAreaAtividade(String areaAtividade) {
		this.areaAtividade = areaAtividade;
	}

	public String getRequisitoAtividade() {
		return requisitoAtividade;
	}

	public void setRequisitoAtividade(String requisitoAtividade) {
		this.requisitoAtividade = requisitoAtividade;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public int getVagasTotal() {
		return vagasTotal;
	}

	public void setVagasTotal(int vagasTotal) {
		this.vagasTotal = vagasTotal;
	}

	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public Ministrante getMinistrante() {
		return ministrante;
	}

	public void setMinistrante(Ministrante ministrante) {
		this.ministrante = ministrante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
