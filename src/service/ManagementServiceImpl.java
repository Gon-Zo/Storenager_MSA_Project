package service;

import java.util.List;

import dao.ManagementDAO;
import vo.Management;

/**
 * @file ManagementServiceImpl.java
 * @brief ManagementServiceImpl class
 * @author park
 * @version 1.0
 */
public class ManagementServiceImpl implements MagaementService {
	private ManagementDAO managementDAO;

	public void setManagementDAO(ManagementDAO managementDAO) {
		this.managementDAO = managementDAO;
	}
	
	/**
	 * @name selectManagement \n
	 * @brief 가게의 제고의 정보 리스트를 출력한다. \n
	 * @return List<Management> \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public List<Management> selectManagement(int storeNo) {
		// TODO Auto-generated method stub
		return managementDAO.selectList(storeNo);
	}

	/**
	 * @name updateManagement \n
	 * @brief 제고 출고의 기능을 하는 함수이다. \n
	 * @param Management management\n
	 * @return Boolean \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public Boolean updateManagement(Management management) {
		// TODO Auto-generated method stub
		int num = management.getNum();
		management.setNum( 
				management.getState().equals("P") ? 
							num + managementDAO.selectOne(management) : managementDAO.selectOne(management) - num
								);
		return managementDAO.updateManagement(management) == 1 ? true : false;
	}
	
}
