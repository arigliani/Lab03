package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String parola;
	private boolean corretto;
	
	
	public RichWord(String parola, boolean corretto) {
		super();
		this.setParola(parola);
		this.setCorretto(corretto);
	}


	/**
	 * @return the parola
	 */
	public String getParola() {
		return parola;
	}


	/**
	 * @param parola the parola to set
	 */
	public void setParola(String parola) {
		this.parola = parola;
	}


	/**
	 * @return the corretto
	 */
	public boolean isCorretto() {
		return corretto;
	}


	/**
	 * @param corretto the corretto to set
	 */
	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (corretto ? 1231 : 1237);
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RichWord other = (RichWord) obj;
		if (corretto != other.corretto)
			return false;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RichWord [parola=" + parola + ", corretto=" + corretto + "]";
	}
	
	
	
	
	

}
