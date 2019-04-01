package service;

import java.util.List;

import vo.Day;

/**
 * @file DayService.java
 * @brief DayService interface
 * @author park
 * @version 1.0
 */
public interface DayService {
	public Boolean writeDay(Day day);

	public List<Day> listDay(int no);

	public Boolean removeDay(int no);
}
