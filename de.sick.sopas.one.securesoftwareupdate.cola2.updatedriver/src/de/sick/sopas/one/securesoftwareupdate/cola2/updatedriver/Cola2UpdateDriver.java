package de.sick.sopas.one.securesoftwareupdate.cola2.updatedriver;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;
import de.sick.sopas.one.securesoftwareupdate.api.IUpdateListener;

public class Cola2UpdateDriver implements IUpdateDriver {

	@Override
	public void startUpdate() {
		System.out.println("Cola 2 Update started!");
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
		return "cola2".equalsIgnoreCase(name) && "1.0.0".equals(version);
	}

}
