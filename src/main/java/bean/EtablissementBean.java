package bean;

import dao.DaoFactory;
import javafx.scene.control.Alert;
import model.Etablissement;
import model.Ville;

import java.util.ArrayList;

public class EtablissementBean {

    private ArrayList<Etablissement> listeEtablissements;


    public EtablissementBean() {
        listeEtablissements= DaoFactory.getEtablissementDAO().getAll();
    }

    public boolean addEtablissement(Etablissement etablissement){
        return DaoFactory.getEtablissementDAO().insert(etablissement);
    }

    public boolean deleteEtablissement(Etablissement etablissement){
        if(DaoFactory.getVilleDAO().counterEtablissementByVille(etablissement.getVille()) == 1){
            System.out.println(etablissement.getVille().getId_ville());
            DaoFactory.getEtablissementDAO().delete(etablissement);
            DaoFactory.getVilleDAO().delete(etablissement.getVille());
        }else{
            DaoFactory.getEtablissementDAO().delete(etablissement);
        }
        return true;
    }

    public boolean updateEtablissement(Etablissement etablissement){
        return DaoFactory.getEtablissementDAO().update(etablissement);
    }

    public ArrayList<Etablissement> getListeEtablissements() {
        return listeEtablissements;
    }

    public void setListeEtablissements(ArrayList<Etablissement> listeEtablissements) {
        this.listeEtablissements = listeEtablissements;
    }
}
