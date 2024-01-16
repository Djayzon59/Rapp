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


    public int returnIdVille(Ville ville){
         ville = DaoFactory.getVilleDAO().getByNom(ville.getLibelleVille());
        if(ville == null){
            return 0;
        }
        return ville.getId_ville();
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
