package server;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7533282343180718819L;
	
	private int lethality;
	private int incubation;
	private int casuality;

	public int getLethality() {
		return lethality;
	}

	public void setLethality(int lethality) {
		this.lethality = lethality;
	}

	public int getIncubation() {
		return incubation;
	}

	public void setIncubation(int incubation) {
		this.incubation = incubation;
	}

	public int getCasuality() {
		return casuality;
	}

	public void setCasuality(int casuality) {
		this.casuality = casuality;
	}

}
