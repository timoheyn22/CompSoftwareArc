package de.leuphana.swa.pricingsystem.behaviour;

import de.leuphana.swa.pricingsystem.service.PricingService;
import de.leuphana.swa.pricingsystem.behaviour.PriceCalculator.Tariff;

public class PricingServiceImpl implements PricingService {

    @Override
    public double calculatePrice(double directDistance, Tariff tariff) {
        // Delegiere zur PriceCalculator-Klasse
        return PriceCalculator.calculatePrice(directDistance, tariff);
    }

    @Override
    public String generateTicket(double directDistance, Tariff tariff) {
        // Delegiere zur PriceCalculator-Klasse
        return PriceCalculator.generateTicket(directDistance, tariff);
    }
}
