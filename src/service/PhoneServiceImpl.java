package service;

import java.util.List;
import dao.PhoneDAO;
import vo.Phone;

/**
 * @file PhoneServiceImpl.java
 * @brief PhoneServiceImpl class
 * @author park
 * @version 1.0
 */
public class PhoneServiceImpl implements PhoneService {
	private PhoneDAO phoneDAO;

	public void setPhoneDAO(PhoneDAO phoneDAO) {
		this.phoneDAO = phoneDAO;
	}
	
	/**
	 * @name writePhone \n
	 * @brief 협럭업체의 정보를 저장하는 함수이다. \n
	 * @param Phone phone \n
	 * @return Boolean \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public Boolean writePhone(Phone phone) {
		// TODO Auto-generated method stub
		return phoneDAO.insertPhone(phone) == 1 ? true : false;
	}
	
	/**
	 * @name phoneBooks \n
	 * @brief 헙력업체 리스트를 출력한다. \n
	 * @param int no \n
	 * @return List<Phone> \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public List<Phone> phoneBooks(int no) {
		// TODO Auto-generated method stub
		return phoneDAO.selectList(no);
	}
	
	/**
	 * @name removePhone \n
	 * @brief 헙력업체의 정보를 삭제한다. \n
	 * @param int no \n
	 * @return Boolean \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public Boolean removePhone(int no) {
		// TODO Auto-generated method stub
		return phoneDAO.deletePhone(no) == 1 ? true : false;
	}

}
