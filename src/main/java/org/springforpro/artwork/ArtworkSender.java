package org.springforpro.artwork;

public interface ArtworkSender {
	public void sendArtwork(String artworkPath, Recipient recipient);
	public String getFreindlyName();
	public String getShortName();
}
