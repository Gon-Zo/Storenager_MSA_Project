package dao;

import java.util.List;

import vo.Management;

/**
 * @file ManagementDAO.java
 * @brief ManagementDAO interface
 * @author park
 * @version 1.0
 */
public interface ManagementDAO {

	public int insertManagement(Management management);

	public List<Management> selectList(int storeNo);

	public int updateManagement(Management management);

	public int selectOne(Management management);
}
