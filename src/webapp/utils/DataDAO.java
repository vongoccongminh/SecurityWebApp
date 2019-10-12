package webapp.utils;

import java.util.HashMap;
import java.util.Map;

import webapp.beans.UserAccount;
import webapp.config.SecurityConfig;

public class DataDAO {

	private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();
	
	static {
		initUsers();
	}

	private static void initUsers() {
		// TODO Auto-generated method stub
		UserAccount emp = new UserAccount("employee", UserAccount.GENDER_MALE, "123", SecurityConfig.ROLE_EMPLOYEE);
		UserAccount mng = new UserAccount("manager", UserAccount.GENDER_FEMALE, "456", SecurityConfig.ROLE_MANAGER);
		
		mapUsers.put(emp.getUserName(), emp);
		mapUsers.put(mng.getUserName(), mng);
	}
	
	public static UserAccount findUser(String userName, String password) {
		
		UserAccount user = mapUsers.get(userName);
		
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		
		return null;
	}
}
