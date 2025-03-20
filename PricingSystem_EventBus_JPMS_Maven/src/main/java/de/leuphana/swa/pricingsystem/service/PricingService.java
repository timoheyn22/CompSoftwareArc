package de.leuphana.swa.pricingsystem.service;

/**
 * Schnittstelle für das Pricing-System.
 * 
 * Berechnet den Preis basierend auf Start- und Zielort sowie einer Tarif-Kategorie.
 */
public interface PricingService {
    /**
     * Berechnet den Preis.
     *
     * @param startLocation der Startort
     * @param destination   der Zielort
     * @param category      z.B. "NORMAL", "GUENSTIGER_REISEN", "SCHNAEPPCHEN"
     * @return berechneter Endpreis
     */
    double calculatePrice(String startLocation, String destination, String category);
}
