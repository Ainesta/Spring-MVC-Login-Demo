package th.co.aware.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import th.co.aware.bean.UserBean;

@Component
public class CombatDAO implements ICombatDAO {

	private JdbcTemplate jdbcTemplate;

	
	//@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//@Override
	public boolean authenticateUser(UserBean userBean) {
		// TODO Auto-generated method stub
		boolean userExists = false;
		int rowcount = jdbcTemplate.queryForInt("select count(*) from users " + " where username = ? and password = ?",
				userBean.getUsername(), userBean.getPassword());
		if (rowcount == 1) {
			userExists = true;
		}
		return userExists;
	}

}
