package com.sahar.entities;

import org.springframework.data.rest.core.config.Projection;



@Projection(name = "nomIn", types = { Instrument.class })
public interface InstrumentProjection {
	public String getNomInstrument();
}