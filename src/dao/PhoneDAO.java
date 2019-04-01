package dao;

import java.util.List;

import vo.Phone;

/**
 * @file PhoneDAO.java
 * @brief PhoneDAO interface
 * @author park
 * @version 1.0
 */
public interface PhoneDAO {
	public int insertPhone(Phone phone);

	public List<Phone> selectList(int no);

	public int deletePhone(int no);
}
