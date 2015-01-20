/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package other;

import java.io.File;

/**  @author igorm  */
public class Other {
	public static void main(String[] args) {
		String classpath = System.getProperty("java.class.path");
		String[] classpathEntries = classpath.split(File.pathSeparator);
		for (String classpathEntry : classpathEntries) {
			System.out.println("Entry.." + classpathEntry);			
		}
	}

}
