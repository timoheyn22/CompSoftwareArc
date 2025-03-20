package de.leuphana.swa.pricingsystem.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class PricingActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("PricingSystem: Bundle started.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("PricingSystem: Bundle stopped.");
    }
}
