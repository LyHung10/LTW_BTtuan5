package vn.iotstar.service;

import vn.iotstar.models.UserModel;

public interface IUserService {
	UserModel findByUserName(String username);
	UserModel login(String username,String password);
	
	
	void insert(UserModel user);
//	void insertregister(UserModel user);

	boolean register(String email, String password, String username, String fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username); 
	boolean checkExistPhone(String phone);
}
