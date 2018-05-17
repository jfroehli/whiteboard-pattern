package de.sick.sopas.one.securesoftwareupdate.core.internal;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;

public class UpdateDriverServiceTracker extends ServiceTracker<IUpdateDriver, IUpdateDriver> {

	public UpdateDriverServiceTracker(BundleContext context) {
		super(context, IUpdateDriver.class, null);
	}

}
