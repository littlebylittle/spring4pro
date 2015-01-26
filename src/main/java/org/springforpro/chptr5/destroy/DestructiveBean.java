package org.springforpro.chptr5.destroy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBean implements InitializingBean{
	private InputStream is = null;
	private String filePath = null;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing bean call");
		if(null == filePath) {
			System.out.println("You must specify the filePath property of " + DestructiveBean.class);
		}
		is = new FileInputStream(filePath);
	}

	public void destroy() {
		System.out.println("Destroing bean ");
		if(null != is) {
			try {
				is.close();
				is = null;
			} catch (IOException ex) {
				System.err.println("WARN: trying to close input stream IOException occured");
			}
		}
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/disposeMethod.xml");
		ctx.refresh();

		DestructiveBean bean = ctx.getBean("destructiveBean", DestructiveBean.class);
		System.out.println("Calling destroy ...");
		ctx.destroy();
		System.out.println("Destroyed!");
	}
}
