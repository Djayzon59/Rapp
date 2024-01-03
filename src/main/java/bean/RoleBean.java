package bean;

import dao.DaoFactory;
import model.Role;

import java.util.ArrayList;

public class RoleBean {
    private ArrayList<Role> listeRoles;


    public RoleBean (){
        listeRoles = new ArrayList<>(DaoFactory.getRoleDAO().getAll());
    }


    public ArrayList<Role> getListeRoles() {
        return listeRoles;
    }

    public void setListeRoles(ArrayList<Role> listeRoles) {
        this.listeRoles = listeRoles;
    }
}
