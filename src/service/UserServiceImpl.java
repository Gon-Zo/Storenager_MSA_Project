package service;

import dao.DayDAO;
import dao.ManagementDAO;
import dao.UserDAO;
import vo.Management;
import vo.User;

/**
 * @file UserServiceImpl.java
 * @brief UserServiceImpl class
 * @author park
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	private ManagementDAO managementDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setManagementDAO(ManagementDAO managementDAO) {
		this.managementDAO = managementDAO;
	}

	/**
	 * @name insertUser \n
	 * @brief insert to user \n
	 * @param User user \n
	 * @return int \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public Boolean joinUser(User user) {
		// TODO Auto-generated method stub
		Boolean cheak = null;
		if (userDAO.insertUser(user) == 1) {
			cheak = managementDAO.insertManagement(new Management(user.getNo())) == 6 ? true : false;
		}
		return cheak;
	}// joinUser end
	
	/**
	 * @name login \n
	 * @brief 로그인 기능의 함수. \n
	 * @param User user \n
	 * @return User \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDAO.selectUser(user);
	}

}
