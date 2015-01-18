package org.springforpro.artwork;

public class FtpArtworkSender implements ArtworkSender{

	@Override
	public void sendArtwork(String artworkPath, Recipient recipient) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getFreindlyName() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getShortName() {
		return "ftp";
	}

}
