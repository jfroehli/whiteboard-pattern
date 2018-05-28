package de.sick.sopas.one.securesoftwareupdate.core.internal.matcher;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;

@Component
public class UpdateDriverMatcher implements IUpdateDriverMatcher {

	@Reference
	private volatile List<IUpdateDriver> updateDriver;

	@Override
	public IUpdateDriver findUpdateDriver(String name, String version) {
		if (hasUpdateDriver()) {
			for (final IUpdateDriver driver : updateDriver) {
				if (driver.accept(name, version)) {
					return driver;
				}
			}
		}
		return null;
	}

	private boolean hasUpdateDriver() {
		return updateDriver != null && !updateDriver.isEmpty();
	}
}
