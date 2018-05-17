package de.sick.sopas.one.securesoftwareupdate.cola2.updatedriver;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;

public class Cola2BundleActivator implements BundleActivator {

	private ServiceRegistration<IUpdateDriver> registration;

	private Cola2UpdateDriver updateDriver = new Cola2UpdateDriver();

	@Override
	public void start(BundleContext context) throws Exception {
		registration = context.registerService(IUpdateDriver.class, updateDriver, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}
}
