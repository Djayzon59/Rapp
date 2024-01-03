package model;

public class Ville {

    private int id_ville;
    private String libelleVille;
    private Pays pays;


    public Ville() {
        this.pays = new Pays();
    }

    public Ville(String libelleVille){
        this.libelleVille = libelleVille;
        this.pays = new Pays();
    }

    public Ville(int id_ville, String libelleVille) {
        this.id_ville = id_ville;
        this.libelleVille = libelleVille;
        this.pays = new Pays();
    }


    public int getId_ville() {
        return id_ville;
    }

    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

    public String getLibelleVille() {
        return libelleVille;
    }

    public void setLibelleVille(String libelleVille) {
        this.libelleVille = libelleVille;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }


    @Override
    public String toString() {
        return libelleVille;
    }
}
