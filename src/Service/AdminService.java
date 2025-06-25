package Service;

import DAO.AdminDAO;
import DAO.AdminDAOImpl;
import exception.AuthenticationException;

public class AdminService {
    private final AdminDAO adminDAO;

    public AdminService(){
        this.adminDAO = new AdminDAOImpl();
    }

    public boolean authenticate(String username,String password) throws AuthenticationException{
        return adminDAO.authenticate(username, password);
    }
    public void registerAdmin(String username,String password) throws AuthenticationException{
        adminDAO.addAdmin(username, password);
    }
}
