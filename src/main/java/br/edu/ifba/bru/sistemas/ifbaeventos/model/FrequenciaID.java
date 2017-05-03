package br.edu.ifba.bru.sistemas.ifbaeventos.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FrequenciaID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Matricula matricula;

	private Horario horario;

	public FrequenciaID() {
	}

	public FrequenciaID(Matricula matricula, Horario horario) {
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
		FrequenciaID other = (FrequenciaID) obj;
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

}
