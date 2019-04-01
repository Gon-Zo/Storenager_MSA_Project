package dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import vo.Management;

/**
 * @file ManagementImpl.java
 * @brief ManagementImpl class
 * @author park
 * @version 1.0
 */
public class ManagementImpl implements ManagementDAO {

	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	/**
	 * @name insertManagement \n
	 * @brief 회원가입시 회원가입 정보와 함께 DB에 저장\n
	 * @param Management management\n
	 * @return int \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public int insertManagement(Management management) {
		// TODO Auto-generated method stub
		int result = 0;
		
		for (String s : management.getTypes()) {
			management.setType(s);
			result += session.insert("management.insertCass", management);
		}
		return result;
	}
	
	/**
	 * @name selectList \n
	 * @brief 가게의 제고의 정보 리스트를 출력한다. \n
	 * @param int storeNo\n
	 * @return List<Management> \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public List<Management> selectList(int storeNo) {
		// TODO Auto-generated method stub
		return session.selectList("management.selectList", storeNo);
	}

	/**
	 * @name updateManagement \n
	 * @brief 제고 출고의 기능을 하는 함수이다. \n
	 * @param Management management\n
	 * @return int \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public int updateManagement(Management management) {
		// TODO Auto-generated method stub
		return session.update("management.updateManagement", management);
	}

	/**
	 * @name selectOne \n
	 * @brief 제고를 업데이트시 현재 제고를 불러오기 위하여 사용 \n
	 * @param Management management\n
	 * @return int \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public int selectOne(Management management) {
		// TODO Auto-generated method stub
		return session.selectOne("management.selectOne", management);
	}

}
