package de.sick.sopas.one.securesoftwareupdate.iolink.updatedriver;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;
import de.sick.sopas.one.securesoftwareupdate.api.IUpdateListener;

public class IOLinkUpdateDriver implements IUpdateDriver {

	@Override
	public void startUpdate() {
		System.out.println("IOLink Update started!");
	}

	@Override
	public void cancelUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerUpdateListener(IUpdateListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterUpdateListener(IUpdateListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean accept(String name, String version) {
		return "iolink".equalsIgnoreCase(name);
	}

}
