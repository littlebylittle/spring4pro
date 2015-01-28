package org.springforpro.chptr5.Factory;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.security.MessageDigest;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {
	private String algorithmName = "MD5";
	private MessageDigest messageDigest = null;


	@Override
	public MessageDigest getObject() throws Exception {
		return this.messageDigest;
	}

	@Override
	public Class<?> getObjectType() {
		return MessageDigest.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.messageDigest = MessageDigest.getInstance(algorithmName);
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
}