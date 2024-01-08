package bean;

import dao.DaoFactory;
import javafx.collections.FXCollections;
import model.Ville;

import java.util.ArrayList;

public class VilleBean {

    private ArrayList<Ville> listeVilles;


    public VilleBean(){
        listeVilles = DaoFactory.getVilleDAO().getAll();
    }


    public ArrayList<Ville> getListeVilles() {
        return listeVilles;
    }


    public boolean isExisting(Ville ville){
         ville = DaoFactory.getVilleDAO().getByNom(ville.getLibelleVille());
        if(ville == null){
            return false;
        }
        return true;
    }

    public void ajouterVille(Ville ville){
        DaoFactory.getVilleDAO().insert(ville);
    }

    public int recupererIdVille(Ville ville){
        return DaoFactory.getVilleDAO().getIdVille(ville);
    }

    public void setListeVilles(ArrayList<Ville> listeVilles) {
        this.listeVilles = listeVilles;
    }
}
