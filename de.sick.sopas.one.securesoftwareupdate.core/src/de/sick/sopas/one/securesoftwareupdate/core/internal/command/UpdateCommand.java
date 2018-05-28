package de.sick.sopas.one.securesoftwareupdate.core.internal.command;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.sick.sopas.one.securesoftwareupdate.core.api.ISecureSoftwareUpdate;

@Component(property = { "osgi.command.scope:String=tutorial",
		"osgi.command.function:String=startUpdate" }, service = UpdateCommand.class)
public class UpdateCommand {

	@Reference
	private ISecureSoftwareUpdate updater;

	public Object startUpdate(final String name, final String version) {
		System.out.println("Start Update for " + name + " " + version);
		updater.startUpdate(name, version);
		return null;
	}
}
