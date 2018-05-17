package de.sick.sopas.one.securesoftwareupdate.core.internal.matcher;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;

public interface IUpdateDriverMatcher {

	IUpdateDriver findUpdateDriver(final String name, final String version);

}
