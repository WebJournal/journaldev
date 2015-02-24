package com.journaldev.jsf.beans;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class CustomPhaseListener implements PhaseListener {

	private static final long serialVersionUID = -1395570878923714114L;

	@Override
	public void afterPhase(PhaseEvent pe) {
		System.out.println("After phase" + pe.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent pe) {

		System.out.println("Before phase" + pe.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {

		return PhaseId.ANY_PHASE;
	}

}
