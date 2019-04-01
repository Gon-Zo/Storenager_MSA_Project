package dao;

import java.util.List;

import vo.User;

/**
 * @file UserDAO.java
 * @brief UserDAO interface
 * @author park
 * @version 1.0
 */
public interface UserDAO {
	
	public int insertUser(User user);

	public User selectUser(User user);

}
