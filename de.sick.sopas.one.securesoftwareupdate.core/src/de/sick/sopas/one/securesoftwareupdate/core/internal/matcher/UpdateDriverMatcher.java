package de.sick.sopas.one.securesoftwareupdate.core.internal.matcher;

import java.util.Collection;
import java.util.function.Supplier;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;

public class UpdateDriverMatcher implements IUpdateDriverMatcher {

	private final Supplier<Collection<IUpdateDriver>> updateDriverSupplier;

	public UpdateDriverMatcher(final Supplier<Collection<IUpdateDriver>> updateDriverSupplier) {
		this.updateDriverSupplier = updateDriverSupplier;
	}

	@Override
	public IUpdateDriver findUpdateDriver(String name, String version) {

		for (final IUpdateDriver driver : updateDriverSupplier.get()) {
			if (driver.accept(name, version)) {
				return driver;
			}
		}
		return null;
	}

}
