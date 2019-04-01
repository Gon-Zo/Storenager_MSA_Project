package service;

import java.util.List;

import vo.Management;
import vo.Phone;
import vo.User;

/**
 * @file UserService.java
 * @brief UserService interface
 * @author park
 * @version 1.0
 */
public interface UserService {
	public Boolean joinUser(User user);

	public User login(User user);

}
