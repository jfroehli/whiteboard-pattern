package de.sick.sopas.one.securesoftwareupdate.core.internal;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;
import de.sick.sopas.one.securesoftwareupdate.core.api.ISecureSoftwareUpdate;
import de.sick.sopas.one.securesoftwareupdate.core.internal.command.UpdateCommand;
import de.sick.sopas.one.securesoftwareupdate.core.internal.matcher.UpdateDriverMatcher;

public class CoreActivator implements BundleActivator {

	private ISecureSoftwareUpdate updater;
	private ServiceRegistration<UpdateCommand> commandProviderService;
	private ServiceTracker<IUpdateDriver, IUpdateDriver> tracker;

	@Override
	public void start(BundleContext context) throws Exception {
		/*
		 * Create tracker for tracking update driver available in application
		 */
		tracker = new ServiceTracker<IUpdateDriver, IUpdateDriver>(context, IUpdateDriver.class, null) {
			@Override
			public IUpdateDriver addingService(ServiceReference<IUpdateDriver> reference) {
				final IUpdateDriver updateDriver = super.addingService(reference);
				return updateDriver;
			}
		};

		/*
		 * Create a new update for running software updates
		 */
		updater = new UpdateBroker(new UpdateDriverMatcher(() -> tracker.getTracked().values()));

		/*
		 * Register command for running the update via the GOGO shell
		 */
		final Dictionary<String, Object> props = new Hashtable<>();
		props.put("osgi.command.scope", "tutorial");
		props.put("osgi.command.function", new String[] { "startUpdate" });
		commandProviderService = context.registerService(UpdateCommand.class, new UpdateCommand(updater), props);

		tracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		tracker.close();
		tracker = null;

		commandProviderService.unregister();
	}
}
