package de.leuphana.swa.pricingsystem.behaviour;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

public class DummyEventAdmin implements EventAdmin {

    @Override
    public void postEvent(Event event) {
        // Dummy-Implementierung: einfach ausgeben, dass ein Event versendet wurde
        System.out.println("[DummyEventAdmin] Event versendet: " + event.getTopic());
    }

    @Override
    public void sendEvent(Event event) {
        // Für Tests reicht postEvent
        postEvent(event);
    }
}
