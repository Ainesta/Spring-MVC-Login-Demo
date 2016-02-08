package th.co.aware.dao;

import javax.sql.DataSource;

import th.co.aware.bean.UserBean;

public interface ICombatDAO {
	
	public abstract void setDataSource(DataSource dataSource);
	public abstract boolean authenticateUser(UserBean userBean);

}
