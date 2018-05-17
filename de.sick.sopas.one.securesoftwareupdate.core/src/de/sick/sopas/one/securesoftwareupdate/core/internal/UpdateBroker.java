package de.sick.sopas.one.securesoftwareupdate.core.internal;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;
import de.sick.sopas.one.securesoftwareupdate.core.api.ISecureSoftwareUpdate;
import de.sick.sopas.one.securesoftwareupdate.core.internal.matcher.IUpdateDriverMatcher;

public class UpdateBroker implements ISecureSoftwareUpdate {

	private final IUpdateDriverMatcher matcher;

	public UpdateBroker(final IUpdateDriverMatcher matcher) {
		this.matcher = matcher;
	}

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
