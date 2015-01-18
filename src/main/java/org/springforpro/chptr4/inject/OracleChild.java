package org.springforpro.chptr4.inject;

public class OracleChild extends Oracle{

	@Override
	public String meaningOfLife() {
		return super.meaningOfLife() + "Fuck you dude! ";	}

}
