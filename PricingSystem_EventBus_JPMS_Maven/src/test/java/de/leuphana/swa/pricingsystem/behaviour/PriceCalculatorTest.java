package de.leuphana.swa.pricingsystem.behaviour;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import de.leuphana.swa.pricingsystem.service.PricingService;

class PriceCalculatorTest {

    private static PricingService pricingService;

    @BeforeAll
    static void setUpBeforeClass() {
        pricingService = new PricingServiceImpl();
        // Setze den DummyEventAdmin, damit kein NullPointerException auftritt
        ((PricingServiceImpl) pricingService).setEventAdmin(new DummyEventAdmin());
    }

    @AfterAll
    static void tearDownAfterClass() {
        pricingService = null;
    }

    @Test
    void testPriceCalculation() {
        double price = pricingService.calculatePrice("Hamburg", "Berlin", "NORMAL");
        System.out.println("Berechneter Preis: " + price);
        assertTrue(price >= 0, "Der Preis sollte >= 0 sein");
    }
}
