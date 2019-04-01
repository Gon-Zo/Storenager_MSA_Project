package service;

import java.util.List;

import vo.Phone;

/**
 * @file PhoneService.java
 * @brief PhoneService interface
 * @author park
 * @version 1.0
 */
public interface PhoneService {
	
	public Boolean writePhone(Phone phone);

	public List<Phone> phoneBooks(int no);
	
	public Boolean removePhone(int no);
}
