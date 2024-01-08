package bean;

import dao.DaoFactory;
import model.Employe;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class EmployeBean {

    private ArrayList<Employe> listeEmployes;


    public EmployeBean() {
        listeEmployes = DaoFactory.getEmployeDAO().getAll();
    }


    public ArrayList<Employe> getListeEmployes() {
        return listeEmployes;
    }

    public void setListeEmployes(ArrayList<Employe> listeEmployes) {
        this.listeEmployes = listeEmployes;
    }
}
