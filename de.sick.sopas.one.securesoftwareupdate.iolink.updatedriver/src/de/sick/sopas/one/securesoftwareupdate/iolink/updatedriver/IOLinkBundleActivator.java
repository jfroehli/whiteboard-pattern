package de.sick.sopas.one.securesoftwareupdate.iolink.updatedriver;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;

public class IOLinkBundleActivator implements BundleActivator {

	private ServiceRegistration<IUpdateDriver> registration;

	private IOLinkUpdateDriver updateDriver = new IOLinkUpdateDriver();

	@Override
	public void start(BundleContext context) throws Exception {
		registration = context.registerService(IUpdateDriver.class, updateDriver, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}
}
