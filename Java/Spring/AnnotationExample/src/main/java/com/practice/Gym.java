package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Gym {

	private Instrument instrument;

	public Instrument getInstrument() {
		return instrument;
	}

	@Autowired
	@Qualifier(value="instrument1")
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
}
