package dao;

import java.util.List;

import vo.Day;

/**
 * @file DayDAO.java
 * @brief DayDAO interface
 * @author park
 * @version 1.0
 */
public interface DayDAO {
	public int insertDay(Day day);

	public List<Day> selectList(int no);

	public int deleteDay(int no);
}
