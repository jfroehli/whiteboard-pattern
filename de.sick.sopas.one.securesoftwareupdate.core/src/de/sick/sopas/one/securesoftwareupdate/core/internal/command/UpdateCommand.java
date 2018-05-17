package de.sick.sopas.one.securesoftwareupdate.core.internal.command;

import de.sick.sopas.one.securesoftwareupdate.core.api.ISecureSoftwareUpdate;

public class UpdateCommand {

	private final ISecureSoftwareUpdate updater;

	public UpdateCommand(final ISecureSoftwareUpdate updater) {
		this.updater = updater;
	}

	public Object startUpdate(final String name, final String version) {
		System.out.println("Start Update for " + name + " " + version);
		updater.startUpdate(name, version);
		return null;
	}
}
