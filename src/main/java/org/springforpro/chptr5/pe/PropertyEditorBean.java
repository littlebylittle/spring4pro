/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.springforpro.chptr5.pe;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;
import org.springframework.context.support.GenericXmlApplicationContext;

/**  @author igorm  */
public class PropertyEditorBean {
	private byte[] bytes;
	private Class cls;
	private Boolean trueOrFalse;
	private List<String> stringList;
	private Date date;
	private Float floatValue;
	private File file;
	private InputStream stream;
	private Locale locale;
	private Pattern pattern;
	private Properties properties;
	private String trimString;
	private URL url;

	public void setBytes(byte[] bytes) {
		System.out.println("Lenght bytes :: " + bytes.length);
		this.bytes = bytes;
	}

	public void setTrueOrFalse(Boolean trueOrFalse) {
		System.out.println("Setting `trueOrFalse` == " + trueOrFalse);
		this.trueOrFalse = trueOrFalse;
	}

	public void setStringList(List<String> stringList) {
		System.out.println("Setting List of string with size::" + stringList.size());
		for (String el : stringList) {
			System.out.println("Element ==  " + el);
		}
		this.stringList = stringList;
	}

	public void setDate(Date date) {
		System.out.println("Setting date = " + date);
		this.date = date;
	}

	public void setFloatValue(Float floatValue) {
		System.out.println("Setting float value = " + floatValue);
		this.floatValue = floatValue;
	}

	public void setFile(File file) {
		System.out.println("Setting file, file name = " + file.getName());
		this.file = file;
	}

	public void setStream(InputStream stream) {
		System.out.println("Setting stream = " + stream);
		this.stream = stream;
	}

	public void setLocale(Locale locale) {
		System.out.println("Setting locale value = " + locale.getDisplayName());
		this.locale = locale;
	}

	public void setPattern(Pattern pattern) {
		System.out.println("Set pattern = " + pattern);
		this.pattern = pattern;
	}

	public void setProperties(Properties properties) {
		System.out.println("Loaded : "  + properties.size() + " properties");
		this.properties = properties;
	}

	public void setTrimString(String trimString) {
		System.out.println("Setting trim sting = " + trimString);
		this.trimString = trimString;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public void setCls(Class cls) {
		System.out.println("Set class for cls variable");
		this.cls = cls;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx  = new GenericXmlApplicationContext();
		ctx.load("classpath:pe/builtin.xml");
		ctx.refresh();
		PropertyEditorBean bean = ctx.getBean("buitlinSample", PropertyEditorBean.class);
	}
}
