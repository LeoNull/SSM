package shop;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.ezi.dao.IUserDao;
import cn.ezi.pojo.User;

import java.io.Reader;

public class TestMybatis {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			IUserDao userOperater = session.getMapper(IUserDao.class);
			User user = userOperater.selectByPrimaryKey(1);
			System.out.println(user.toString());

		} finally {
			session.close();
		}
	}
}
