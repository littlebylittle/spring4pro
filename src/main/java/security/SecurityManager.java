/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

/**  @author igorm  */
public class SecurityManager {
	private static final ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();
	public void login(String username, String passwd) {
		threadLocal.set(new UserInfo(username, passwd));
	}
	
	public void logout() {
		threadLocal.set(null);
	}
	
	public UserInfo getLoggedUser() {
		return threadLocal.get();
	}
}