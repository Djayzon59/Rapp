package bean;

import dao.DaoFactory;
import model.Etablissement;

import java.util.ArrayList;

public class EtablissementBean {

    private ArrayList<Etablissement> listeEtablissements;


    public EtablissementBean() {
        listeEtablissements= DaoFactory.getEtablissementDAO().getAll();
    }

    public boolean addEtablissement(Etablissement etablissement){
        boolean isInserted = DaoFactory.getEtablissementDAO().insert(etablissement);
        return isInserted;
    }

    public ArrayList<Etablissement> getListeEtablissements() {
        return listeEtablissements;
    }

    public void setListeEtablissements(ArrayList<Etablissement> listeEtablissements) {
        this.listeEtablissements = listeEtablissements;
    }
}
