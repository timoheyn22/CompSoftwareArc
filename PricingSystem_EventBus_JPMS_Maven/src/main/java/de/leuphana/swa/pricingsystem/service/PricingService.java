package de.leuphana.swa.pricingsystem.service;

import de.leuphana.swa.pricingsystem.behaviour.PriceCalculator.Tariff;

public interface PricingService {
    /**
     * Berechnet den Preis basierend auf der direkten Entfernung und dem gewählten Tarif.
     *
     * @param directDistance direkte Entfernung in km
     * @param tariff Tarif, der angewendet wird
     * @return berechneter Preis
     */
    double calculatePrice(double directDistance, Tariff tariff);

    /**
     * Generiert ein Ticket basierend auf der direkten Entfernung und dem Tarif.
     *
     * @param directDistance direkte Entfernung in km
     * @param tariff Tarif, der angewendet wird
     * @return Ticket als String
     */
    String generateTicket(double directDistance, Tariff tariff);
}
