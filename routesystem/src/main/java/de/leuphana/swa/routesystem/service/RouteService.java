package de.leuphana.swa.routesystem.service;

/**
 * Einfache Schnittstelle zur Berechnung einer Route (Entfernung) zwischen zwei Orten.
 */
public interface RouteService {
    /**
     * Berechnet die Route (Entfernung in km) zwischen Start- und Zielort.
     *
     * @param start       Startort
     * @param destination Zielort
     * @return berechnete Entfernung in km
     */
    double calculateRoute(String start, String destination);
}
