package dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import vo.Phone;

/**
 * @file PhoneDAOImpl.java
 * @brief PhoneDAOImpl class
 * @author park
 * @version 1.0
 */
public class PhoneDAOImpl implements PhoneDAO {
	
	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	/**
	 * @name insertPhone \n
	 * @brief 협럭업체의 정보를 저장하는 함수이다. \n
	 * @param Phone phone \n
	 * @return int \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public int insertPhone(Phone phone) {
		// TODO Auto-generated method stub
		return session.insert("phone.insertPhone", phone);
	}

	/**
	 * @name selectList \n
	 * @brief 헙력업체 리스트를 출력한다. \n
	 * @param int no \n
	 * @return List<Phone> \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public List<Phone> selectList(int no) {
		// TODO Auto-generated method stub
		return session.selectList("phone.selectList", no);
	}

	/**
	 * @name deletePhone \n
	 * @brief 헙력업체의 정보를 삭제한다. \n
	 * @param int no \n
	 * @return int \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public int deletePhone(int no) {
		// TODO Auto-generated method stub
		return session.delete("phone.deletePhone", no);
	}

}
