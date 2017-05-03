package br.edu.ifba.bru.sistemas.ifbaeventos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FREQUENCIA")
@IdClass(FrequenciaID.class)
public class Frequencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean presente;
	
	@Id
	@ManyToOne
	@Column(name = "participante_id")
	private Matricula matricula;

	@Id
	@ManyToOne
	@Column(name = "horario_id")
	private Horario horario;

	public Frequencia() {
	}

	public Frequencia(Matricula matricula, Horario horario) {
		this.matricula = matricula;
		this.horario = horario;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Frequencia other = (Frequencia) obj;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	public Boolean getPresente() {
		return presente;
	}

	public void setPresente(Boolean presente) {
		this.presente = presente;
	}
	
//	public static class FrequenciaID implements Serializable {
//
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//		
//		private Participante participante;
//
//		private Horario horario;
//
//		public FrequenciaID(Participante participante, Horario horario) {
//			this.participante = participante;
//			this.horario = horario;
//		}
//
//		public FrequenciaID() {
//		}
//
//		public Participante getParticipante() {
//			return participante;
//		}
//
//		public void setParticipante(Participante participante) {
//			this.participante = participante;
//		}
//
//		public Horario getHorario() {
//			return horario;
//		}
//
//		public void setHorario(Horario horario) {
//			this.horario = horario;
//		}
//	}

	
}
