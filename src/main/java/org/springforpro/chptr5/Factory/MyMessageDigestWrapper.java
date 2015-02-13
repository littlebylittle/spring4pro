/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.springforpro.chptr5.Factory;

import java.security.MessageDigest;

/**  @author igorm  */
public class MyMessageDigestWrapper {
	private MessageDigest digest;

	public MessageDigest getDigest() {
		return digest;
	}

	public void setDigest(MessageDigest digest) {
		this.digest = digest;
	}

	public MyMessageDigestWrapper(MessageDigest digest) {
		this.digest = digest;
	}			
}