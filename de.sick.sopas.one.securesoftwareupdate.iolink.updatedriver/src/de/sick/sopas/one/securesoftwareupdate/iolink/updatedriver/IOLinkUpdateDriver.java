package de.sick.sopas.one.securesoftwareupdate.iolink.updatedriver;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import de.sick.sopas.one.securesoftwareupdate.api.IUpdateDriver;
import de.sick.sopas.one.securesoftwareupdate.api.IUpdateListener;

@Component
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
	
	@Activate
	public void onActivate() {
		System.out.println("IOLink Driver activated!");
	}

}
