package bean;

import dao.DaoFactory;
import model.Pays;

import java.util.ArrayList;

public class PaysBean {

    private ArrayList<Pays> listePays;



    public PaysBean(){
    }


    public ArrayList<Pays> getListePays() {
        return listePays;
    }

    public void setListePays(ArrayList<Pays> listePays) {
        this.listePays = listePays;
    }
}
