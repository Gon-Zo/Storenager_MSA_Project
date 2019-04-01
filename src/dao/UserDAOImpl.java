package dao;

import org.apache.ibatis.session.SqlSession;
import vo.User;

/**
 * @file UserDAOImpl.java
 * @brief UserDAOImpl class
 * @author park
 * @version 1.0
 */
public class UserDAOImpl implements UserDAO {

	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	/**
	 * @name insertUser \n
	 * @brief 유저 정보를 DB에 저장 \n
	 * @param User user \n
	 * @return int \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return session.insert("user.insert", user);
	}

	/**
	 * @name selectUser \n
	 * @brief 로그인 기능의 함수. \n
	 * @param User user \n
	 * @return User \n
	 * @author park \n
	 * @version 1.0 \n
	 * @see None \n
	 */
	@Override
	public User selectUser(User user) {
		// TODO Auto-generated method stub
		return session.selectOne("user.selectUser", user);
	}

}
