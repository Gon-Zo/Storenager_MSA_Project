package service;

import java.util.List;

import dao.DayDAO;
import vo.Day;

/**
 * @file DayServiceImpl.java
 * @brief DayServiceImpl class
 * @author park
 * @version 1.0
 */
public class DayServiceImpl implements DayService {
	private DayDAO dayDAO;

	public void setDayDAO(DayDAO dayDAO) {
		this.dayDAO = dayDAO;
	}

	/**
	 * @name writeDay \n
	 * @brief 스케줄의 정보를 쓸 수 있다.\n
	 * @param Day day \n
	 * @return Boolean \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public Boolean writeDay(Day day) {
		// TODO Auto-generated method stub
		return dayDAO.insertDay(day) == 1 ? true : false;
	}

	/**
	 * @name listDay \n
	 * @brief 스케줄의 리스트를 불러오는 함수이다.\n
	 * @return List<Day> \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public List<Day> listDay(int no) {
		// TODO Auto-generated method stub
		return dayDAO.selectList(no);
	}

	/**
	 * @name removeDay \n
	 * @brief 스케줄의 삭제할 때 사용한다.\n
	 * @param int no\n
	 * @return Boolean \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public Boolean removeDay(int no) {
		// TODO Auto-generated method stub
		return dayDAO.deleteDay(no) == 1 ? true : false;
	}
	
}
