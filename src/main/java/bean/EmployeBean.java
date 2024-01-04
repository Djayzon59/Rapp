package bean;

import dao.DaoFactory;
import model.Employe;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class EmployeBean {

    private ArrayList<Employe> listeEmployes;


    public EmployeBean() {
        Employe employe = new Employe();

        employe.setNomEmploye("Darmanin");
        employe.setPrenomEmploye("Gerald");
        employe.setMailEmploye("geraldDarmanin@gmail.fr");
        employe.setDateEntreeEmploye(LocalDateTime.now());
        employe.setDateSortieEmploye(null);
        employe.setPasswordEmploye("password");
        employe.getRole().setId_role(3);
        employe.getClient().setId_client(7);
        DaoFactory.getEmployeDAO().insert(employe);
    }


    public ArrayList<Employe> getListeEmployes() {
        return listeEmployes;
    }

    public void setListeEmployes(ArrayList<Employe> listeEmployes) {
        this.listeEmployes = listeEmployes;
    }
}
