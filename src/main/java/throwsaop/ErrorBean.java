/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package throwsaop;

/**  @author igorm  */
public class ErrorBean {
	public void errorProneMethod() throws Exception {
		throw new Exception("foo");
	}
	public void otherErrorProneMethod() throws IllegalArgumentException {
		throw new IllegalArgumentException("Bar");
	}
}
