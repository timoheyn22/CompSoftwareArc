package de.leuphana.swa.pricingsystem.behaviour;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PriceCalculatorTest {

    @Test
    void testCalculateRouteDistance() {
        double directDistance = 100.0;
        double expectedDistance = directDistance * 1.45;
        double actualDistance = PriceCalculator.calculateRouteDistance(directDistance);
        assertEquals(expectedDistance, actualDistance, 0.0001, "Die berechnete Strecke sollte korrekt sein.");
    }
    
    @Test
    void testCalculatePriceNormal() {
        double directDistance = 100.0;
        double routeDistance = PriceCalculator.calculateRouteDistance(directDistance);
        double expectedPrice = routeDistance * 0.03; // Normal-Tarif
        double actualPrice = PriceCalculator.calculatePrice(directDistance, PriceCalculator.Tariff.NORMAL);
        assertEquals(expectedPrice, actualPrice, 0.0001, "Der Preis im Normal-Tarif sollte korrekt berechnet werden.");
    }
    
    @Test
    void testCalculatePriceGuenstigerReisen() {
        double directDistance = 100.0;
        double routeDistance = PriceCalculator.calculateRouteDistance(directDistance);
        double basePrice = routeDistance * 0.03;
        double expectedPrice = basePrice * 0.75; // 75% des Normalpreises
        double actualPrice = PriceCalculator.calculatePrice(directDistance, PriceCalculator.Tariff.GUENSTIGER_REISEN);
        assertEquals(expectedPrice, actualPrice, 0.0001, "Der Preis im GünstigerReisen-Tarif sollte 75% des Normalpreises betragen.");
    }
    
    @Test
    void testCalculatePriceSchnäppchen() {
        double directDistance = 100.0;
        double routeDistance = PriceCalculator.calculateRouteDistance(directDistance);
        double basePrice = routeDistance * 0.03;
        double expectedPrice = basePrice * 0.50; // 50% des Normalpreises
        double actualPrice = PriceCalculator.calculatePrice(directDistance, PriceCalculator.Tariff.SCHNAEPPCHEN);
        assertEquals(expectedPrice, actualPrice, 0.0001, "Der Preis im Schnäppchen-Tarif sollte 50% des Normalpreises betragen.");
    }
    
    @Test
    void testGenerateTicket() {
        double directDistance = 50.0;
        String ticket = PriceCalculator.generateTicket(directDistance, PriceCalculator.Tariff.NORMAL);
        assertNotNull(ticket, "Das generierte Ticket sollte nicht null sein.");
        assertTrue(ticket.contains("Ticket"), "Das Ticket sollte den Titel 'Ticket' enthalten.");
    }
}
