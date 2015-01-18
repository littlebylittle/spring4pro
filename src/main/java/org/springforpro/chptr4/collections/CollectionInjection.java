package org.springforpro.chptr4.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionInjection {
	private Map<String, Object> map;
	private Properties props;
	private Set set;
	private List list;
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:collections/collections-app.xml");
		ctx.refresh();
	}
}
