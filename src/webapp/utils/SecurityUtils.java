package webapp.utils;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import webapp.config.SecurityConfig;

public class SecurityUtils {

	public static boolean isSecurityPage(HttpServletRequest req) {

		String urlPattern = UrlPatternUtils.getUrlPattern(req);
		Set<String> roles = SecurityConfig.getAllRoles();
		
		for(String role : roles){
			List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
			if(urlPatterns != null && urlPatterns.contains(urlPattern)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean hasPermission(HttpServletRequest req) {
		
		String urlPattern = UrlPatternUtils.getUrlPattern(req);
		Set<String> allRoles = SecurityConfig.getAllRoles();
		
		for(String role : allRoles) {
			if(!req.isUserInRole(role)) {
				continue;
			}
			
			List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
			if(urlPatterns != null && urlPatterns.contains(urlPattern)) {
				return true;
			}
		}
		return false;
	}
}
