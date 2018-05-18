package com.journaldev.jsf.beans;

import javax.faces.FactoryFinder;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;

@ManagedBean
@SessionScoped
public class MobileActionListener implements ActionListener {

	public MobileActionListener() {
	}

	@Override
	public void processAction(ActionEvent ae) throws AbortProcessingException {

		UIComponent ui = ae.getComponent();

		System.out.println("Event source is" + ui.getClass().getName());

	}

	public void listAllPhaseListeners() {
		LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder
				.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
		Lifecycle applicationLifecycle = lifecycleFactory
				.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

		PhaseListener phaseListeners[] = applicationLifecycle
				.getPhaseListeners();
		for (PhaseListener phaseListener : phaseListeners) {
			System.out.println(phaseListener.getPhaseId());
		}
	}

}
