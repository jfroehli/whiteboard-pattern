package de.sick.sopas.one.securesoftwareupdate.core.internal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;
import de.sick.sopas.one.securesoftwareupdate.core.api.ISecureSoftwareUpdate;
import de.sick.sopas.one.securesoftwareupdate.core.internal.matcher.IUpdateDriverMatcher;

@Component
public class UpdateBroker implements ISecureSoftwareUpdate {

	@Reference
	private IUpdateDriverMatcher matcher;

	@Override
	public void startUpdate(final String name, final String version) {
		final IUpdateDriver updateDriver = matcher.findUpdateDriver(name, version);

		if (updateDriver == null) {
			System.out.println("No UpdateDriver found!");
		} else {
			updateDriver.startUpdate();
		}
	}
}
