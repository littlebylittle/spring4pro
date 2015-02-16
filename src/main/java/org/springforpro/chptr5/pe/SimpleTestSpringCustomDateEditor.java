package org.springforpro.chptr5.pe;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class SimpleTestSpringCustomDateEditor {
	public static void main(String[] args) {
		Object o = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat sdf = (DateFormat) o;
		CustomDateEditor ed = new CustomDateEditor(sdf, true);
//		System.out.println("ed = " + ((Date) ed));
	}
}
