package DAO;

import exception.AuthenticationException;

public interface AdminDAO {
    boolean authenticate(String username, String password) throws AuthenticationException;
    void addAdmin(String username, String password);
}

