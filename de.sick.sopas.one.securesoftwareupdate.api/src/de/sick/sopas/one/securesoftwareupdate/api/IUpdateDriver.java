package de.sick.sopas.one.securesoftwareupdate.api;

public interface IUpdateDriver {

	boolean accept(final String name, final String version);
	
	void startUpdate();

	void cancelUpdate();

	void registerUpdateListener(final IUpdateListener listener);

	void unregisterUpdateListener(final IUpdateListener listener);
}
