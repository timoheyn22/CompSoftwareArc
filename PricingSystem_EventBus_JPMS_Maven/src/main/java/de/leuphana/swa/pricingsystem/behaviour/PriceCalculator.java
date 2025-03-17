package de.leuphana.swa.pricingsystem.behaviour;

public class PriceCalculator {

    // Enum für die Tarifarten
    public enum Tariff {
        NORMAL,           // Normal-Tarif: 100% des Basispreises
        GUENSTIGER_REISEN, // GünstigerReisen-Tarif: 75% des Normalpreises
        SCHNAEPPCHEN      // Schnäppchen-Tarif: 50% des Normalpreises
    }
    
    /**
     * Berechnet die Route in Kilometern.
     * Formel: direkte Entfernung * 1.45.
     *
     * @param directDistance direkte Entfernung in Kilometern
     * @return berechnete Route in Kilometern
     */
    public static double calculateRouteDistance(double directDistance) {
        return directDistance * 1.45;
    }
    
    /**
     * Berechnet den Fahrpreis basierend auf der direkten Entfernung und dem Tarif.
     * Jeder Fahrtkilometer kostet im Normal-Tarif 0,03 Euro.
     *
     * @param directDistance direkte Entfernung in Kilometern
     * @param tariff Tarif, der angewendet werden soll
     * @return berechneter Fahrpreis in Euro
     */
    public static double calculatePrice(double directDistance, Tariff tariff) {
        double routeDistance = calculateRouteDistance(directDistance);
        double basePrice = routeDistance * 0.03; // Basispreis im Normal-Tarif
        double finalPrice;
        
        switch (tariff) {
            case NORMAL:
                finalPrice = basePrice;
                break;
            case GUENSTIGER_REISEN:
                finalPrice = basePrice * 0.75;
                break;
            case SCHNAEPPCHEN:
                finalPrice = basePrice * 0.50;
                break;
            default:
                finalPrice = basePrice;
        }
        return finalPrice;
    }
    
    /**
     * Generiert ein Ticket-Dokument als String.
     * Das Ticket enthält das aktuelle Datum, die Route und den Gesamtpreis.
     *
     * @param directDistance direkte Entfernung in Kilometern
     * @param tariff Tarif, der angewendet wird
     * @return Ticket-Dokument als String
     */
    public static String generateTicket(double directDistance, Tariff tariff) {
        double routeDistance = calculateRouteDistance(directDistance);
        double price = calculatePrice(directDistance, tariff);
        String ticket = "Ticket\n" +
                        "Datum: " + java.time.LocalDate.now() + "\n" +
                        "Direkte Entfernung: " + directDistance + " km\n" +
                        "Berechnete Strecke: " + routeDistance + " km\n" +
                        "Tarif: " + tariff + "\n" +
                        "Gesamtpreis: " + String.format("%.2f", price) + " Euro";
        return ticket;
    }
}
