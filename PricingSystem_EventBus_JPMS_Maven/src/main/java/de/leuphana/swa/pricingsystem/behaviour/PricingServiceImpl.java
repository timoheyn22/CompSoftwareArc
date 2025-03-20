package de.leuphana.swa.pricingsystem.behaviour;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import java.util.HashMap;
import java.util.Map;
import de.leuphana.swa.pricingsystem.service.PricingService;

@Component(service = PricingService.class, immediate = true)
public class PricingServiceImpl implements PricingService {

    @Reference
    private EventAdmin eventAdmin;

    @Override
    public double calculatePrice(String startLocation, String destination, String category) {
        // Beispiel-Implementierung: Preis wird zufällig generiert
        double price = Math.random() * 50;

        // Event versenden (hier wird eventAdmin verwendet)
        Map<String, Object> properties = new HashMap<>();
        properties.put("startLocation", startLocation);
        properties.put("destination", destination);
        properties.put("category", category);
        properties.put("calculatedPrice", price);

        Event priceEvent = new Event("pricing/calculate", properties);
        if (eventAdmin != null) {
            eventAdmin.postEvent(priceEvent);
        } else {
            System.out.println("Warnung: eventAdmin ist null, Event wird nicht versendet.");
        }

        return price;
    }

    // Setter für den Test (nicht für den Produktionseinsatz gedacht)
    public void setEventAdmin(EventAdmin eventAdmin) {
        this.eventAdmin = eventAdmin;
    }
}
