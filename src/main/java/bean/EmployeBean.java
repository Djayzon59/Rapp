package bean;

import dao.DaoFactory;
import model.Employe;
import model.Etablissement;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class EmployeBean {

    private ArrayList<Employe> listeEmployes;


    public EmployeBean() {
        listeEmployes = DaoFactory.getEmployeDAO().getAll();
    }

    public boolean addEmploye(Employe employe){
        boolean isInserted = DaoFactory.getEmployeDAO().insert(employe);
        return isInserted;
    }
    public ArrayList<Employe> getListeEmployes() {
        return listeEmployes;
    }

    public void setListeEmployes(ArrayList<Employe> listeEmployes) {
        this.listeEmployes = listeEmployes;
    }
}
