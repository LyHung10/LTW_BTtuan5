package vn.iotstar.service.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.service.IUserService;

public class UserServiceImpl implements IUserService {
	// lay toan bo ham trong tang DAO cuar user
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	public static void main(String[] args) {

		try {
			IUserService userService = new UserServiceImpl();
			System.out.println(userService.login("hung", "123"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insert(UserModel user) 
	{
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(email,password, username, fullname, phone));
//		userDao.insert(new UserModel(email, username, fullname,password,
//				null,5,phone,date));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

}