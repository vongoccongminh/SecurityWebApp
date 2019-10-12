package webapp.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import webapp.beans.UserAccount;

public class AppUtils {

	private static int REDIRECT_ID = 0;
	private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
	private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();
	
	public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {
		session.setAttribute("loginedUser", loginedUser);
	}
	
	public static UserAccount getLoginedUser(HttpSession session) {
		UserAccount user = (UserAccount) session.getAttribute("loginedUser");
		return user;
	}

	public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
		// TODO Auto-generated method stub
		
		Integer id = uri_id_map.get(requestUri);
		
		if(id == null) {
			id = REDIRECT_ID++;
			uri_id_map.put(requestUri, id);
			id_uri_map.put(id, requestUri);
			
			return id;
		}
		return id;
	}

	public static String getRedirectAfterLoginUrl(HttpSession session, int redirectID) {
		// TODO Auto-generated method stub
		String url = id_uri_map.get(redirectID);
		if(url != null) {
			return url;
		}
		return null;
	}
}
