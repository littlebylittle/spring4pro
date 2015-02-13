package org.springforpro.chptr5.Factory;

import java.security.MessageDigest;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {
	private String algorithmName = "MD5";
	private MessageDigest messageDigest = null;

	@Override
	public MessageDigest getObject() throws Exception {
		return this.messageDigest;
//		return MessageDigest.getInstance(algorithmName);
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("Call getObjectType");
		return MessageDigest.class;
	}

	@Override
	public boolean isSingleton() {
		System.out.println("Check is singleton");
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Call factory's method `afterProperties` with spring");
		//call real factory
		this.messageDigest = MessageDigest.getInstance(algorithmName);
		System.out.println(this.messageDigest);
	}

	public void setAlgorithmName(String algorithmName) {
		System.out.println("Call setAlgo name!");
		this.algorithmName = algorithmName;
	}
}