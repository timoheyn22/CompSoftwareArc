package de.leuphana.swa.routesystem.behaviour;

import de.leuphana.swa.routesystem.service.RouteService;
import org.osgi.service.component.annotations.Component;

/**
 * Implementierung von RouteService als OSGi Declarative Service.
 */
@Component(service = RouteService.class, immediate = true)
public class RouteServiceImpl implements RouteService {

    @Override
    public double calculateRoute(String start, String destination) {
        // Beispiel-Dummy: wenn Start = Ziel, 0 km, sonst 20 km
        if (start.equalsIgnoreCase(destination)) {
            return 0.0;
        }
        return 20.0;
    }
}
