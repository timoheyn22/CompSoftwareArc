package de.leuphana.swa.routesystem.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Klassischer OSGi-BundleActivator für das RouteSystem.
 */
public class RouteSystemActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("RouteSystem Bundle started.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("RouteSystem Bundle stopped.");
    }
}
