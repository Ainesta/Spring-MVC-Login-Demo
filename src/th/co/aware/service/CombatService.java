package th.co.aware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import th.co.aware.bean.UserBean;
import th.co.aware.dao.ICombatDAO;

@Component
public class CombatService implements ICombatService {

	@Autowired
	private ICombatDAO combatDAO;

	public ICombatDAO getCombatDAO() {
		return combatDAO;
	}

	public void setCombatDAO(ICombatDAO combatDAO) {
		this.combatDAO = combatDAO;
	}

	public boolean authenticateUser(UserBean userBean) {
		// TODO Auto-generated method stub
		return combatDAO.authenticateUser(userBean);
	}

}
