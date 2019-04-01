package service;

import java.util.List;

import vo.Management;

/**
 * @file MagaementService.java
 * @brief MagaementService interface
 * @author park
 * @version 1.0
 */
public interface MagaementService {
	public List<Management> selectManagement(int storeNo);

	public Boolean updateManagement(Management management);
}
