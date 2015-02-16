package org.springforpro.chptr5.Factory;

import java.security.MessageDigest;
import java.util.Arrays;

public class MessageDigester {
	private MessageDigest digest1;
	private MessageDigest digest2;

	public MessageDigest getDigest1() {
		return digest1;
	}

	public void setDigest1(MessageDigest digest1) {
		this.digest1 = digest1;
	}

	public void setDigest2(MessageDigest digest2) {
		this.digest2 = digest2;
	}

	public MessageDigest getDigest2() {
		return digest2;
	}

	public void showDiff() {
		System.out.println("Equals of digest1 and digest2 is :" + this.digest1.equals(digest2));
	}
	
	public void digest(String msg) {
		System.out.println("Using digest1 ...");
		digest(msg, digest1);
		System.out.println("Using digest2 ...");
		digest(msg, digest2);

	}

	private void digest(String msg, MessageDigest digest) {
		System.out.println("Using algorithm  " + digest.getAlgorithm() + 
				", for message = " + msg);
		digest.reset();
		byte[] bytes = msg.getBytes();
		byte[] out = digest.digest(bytes);
		System.out.println("Out = " + out + 
				" :: Call class-incstance MessageDigest :" + 
				digest.toString());
	}
}