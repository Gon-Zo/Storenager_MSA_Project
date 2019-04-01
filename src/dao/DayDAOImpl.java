package dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import vo.Day;

/**
 * @file DayDAOImpl.java
 * @brief DayDAOImpl class
 * @author park
 * @version 1.0
 */
public class DayDAOImpl implements DayDAO {

	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	/**
	 * @name insertDay \n
	 * @brief 스케줄의 정보를 쓸 수 있다.\n
	 * @param Day day \n
	 * @return int \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public int insertDay(Day day) {
		// TODO Auto-generated method stub
		return session.insert("day.insertDay", day);
	}

	/**
	 * @name selectList \n
	 * @brief 스케줄의 리스트를 불러오는 함수이다.\n
	 * @return List<Day> \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public List<Day> selectList(int no) {
		// TODO Auto-generated method stub
		return session.selectList("day.selectList", no);
	}
	
	/**
	 * @name deleteDay \n
	 * @brief 스케줄의 삭제할 때 사용한다.\n
	 * @param int no\n
	 * @return int \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public int deleteDay(int no) {
		// TODO Auto-generated method stub
		return session.delete("day.deleteDay", no);
	}

}
