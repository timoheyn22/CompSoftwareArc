package de.leuphana.swa.routesystem.behaviour;

import de.leuphana.swa.routesystem.service.RouteService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Reagiert auf "route/select" Events, ruft RouteService auf und publiziert "route/calculated".
 */
@Component(
    service = EventHandler.class,
    property = {
        "event.topics=route/select"
    },
    immediate = true
)
public class RouteEventHandler implements EventHandler {

    @Reference
    private RouteService routeService;

    @Reference
    private EventAdmin eventAdmin;

    @Override
    public void handleEvent(Event event) {
        String start = (String) event.getProperty("start");
        String destination = (String) event.getProperty("destination");

        // Route berechnen
        double distance = routeService.calculateRoute(start, destination);

        // Neues Event publizieren, z.B. "route/calculated"
        Map<String, Object> props = new HashMap<>();
        props.put("start", start);
        props.put("destination", destination);
        props.put("routeDistance", distance);

        Event newEvent = new Event("route/calculated", props);
        eventAdmin.postEvent(newEvent);

        System.out.println("[RouteEventHandler] route/select -> route/calculated, Distance: " + distance);
    }
}
