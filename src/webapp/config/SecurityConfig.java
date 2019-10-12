package webapp.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {
	
	public static final String ROLE_MANAGER = "MANAGER";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	
	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();
	
	static {
		init();
	}

	private static void init() {
		// TODO Auto-generated method stub
		List<String> urlPatternsEmployee = new ArrayList<String>();
		
		urlPatternsEmployee.add("/userInfo");
		urlPatternsEmployee.add("/employeeTask");
		
		mapConfig.put(ROLE_EMPLOYEE, urlPatternsEmployee);
		
		List<String> urlPatternsManager = new ArrayList<String>();
		
		urlPatternsManager.add("/userInfo");
		urlPatternsManager.add("/managerTask");
		
		mapConfig.put(ROLE_MANAGER, urlPatternsManager);
	}
	
	public static Set<String> getAllRoles(){
		return mapConfig.keySet();
	}
	
	public static List<String> getUrlPatternsForRole(String role) {
		return mapConfig.get(role);
	}
}
