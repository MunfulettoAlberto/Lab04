package it.polito.tdp.lab04.model;

import java.util.*;

public class IscrittiPerCorso {

	private String codiceCorso;
	private int studente;
	
	public IscrittiPerCorso(String codiceCorso, int studente) {
		super();
		this.codiceCorso = codiceCorso;
		this.studente = studente;
	}

	public String getCodiceCorso() {
		return codiceCorso;
	}

	public void setCodiceCorso(String codiceCorso) {
		this.codiceCorso = codiceCorso;
	}


	public int getStudente() {
		return studente;
	}

	public void setStudente(int studente) {
		this.studente = studente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceCorso == null) ? 0 : codiceCorso.hashCode());
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
		IscrittiPerCorso other = (IscrittiPerCorso) obj;
		if (codiceCorso == null) {
			if (other.codiceCorso != null)
				return false;
		} else if (!codiceCorso.equals(other.codiceCorso))
			return false;
		return true;
	}
	
	
}
