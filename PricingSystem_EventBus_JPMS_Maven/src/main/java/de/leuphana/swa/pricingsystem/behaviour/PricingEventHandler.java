package de.leuphana.swa.pricingsystem.behaviour;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

@Component(
    service = EventHandler.class,
    property = "event.topics=pricing/calculate"
)
public class PricingEventHandler implements EventHandler {

    @Override
    public void handleEvent(Event event) {
        System.out.println("PricingEventHandler received event: " + event.getTopic());
        // Hier weitere Verarbeitungslogik einfügen
    }
}
