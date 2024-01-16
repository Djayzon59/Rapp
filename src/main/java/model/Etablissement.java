package model;

public class Etablissement {

    private int id_etablissement;
    private String libelleEtablissement;
    private String numeroRueEtablissement;
    private String libelleRueEtablissement;
    private String complementAdresseEtablissement;
    private String codePostalEtablissement;
    private String numeroIdentification;
    private String latitude;
    private String longitude;
    private String numMobileEtablissement;
    private String numFixeEtablissement;

    private Employe employe;
    private Client client;
    private Ville ville;


    public Etablissement(String libelleEtablissement) {
        this.libelleEtablissement=libelleEtablissement;
    }

    public Etablissement(String libelleEtablissement, String numeroRueEtablissement, String libelleRueEtablissement, String complementAdresseEtablissement, String codePostalEtablissement, String numeroIdentification, String numMobileEtablissement, String numFixeEtablissement) {
        this.libelleEtablissement=libelleEtablissement;
        this.numeroRueEtablissement=numeroRueEtablissement;
        this.libelleRueEtablissement=libelleRueEtablissement;
        this.complementAdresseEtablissement=complementAdresseEtablissement;
        this.codePostalEtablissement=codePostalEtablissement;
        this.numeroIdentification=numeroIdentification;
        this.numMobileEtablissement=numMobileEtablissement;
        this.numFixeEtablissement=numFixeEtablissement;
    }

    public Etablissement(int id_etablissement, String libelleEtablissement, String numeroRueEtablissement, String libelleRueEtablissement, String complementAdresseEtablissement, String codePostalEtablissement, String numeroIdentification, String latitude, String longitude, String numMobileEtablissement, String numFixeEtablissement, Employe employe, Ville ville) {
        this.id_etablissement = id_etablissement;
        this.libelleEtablissement = libelleEtablissement;
        this.numeroRueEtablissement = numeroRueEtablissement;
        this.libelleRueEtablissement = libelleRueEtablissement;
        this.complementAdresseEtablissement = complementAdresseEtablissement;
        this.codePostalEtablissement = codePostalEtablissement;
        this.numeroIdentification = numeroIdentification;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numMobileEtablissement = numMobileEtablissement;
        this.numFixeEtablissement = numFixeEtablissement;
        this.employe = employe;
        this.ville = ville;
    }

    public Etablissement() {
        employe = new Employe();
        client = new Client();
        ville = new Ville();
    }

    public int getId_etablissement() {
        return id_etablissement;
    }

    public void setId_etablissement(int id_etablissement) {
        this.id_etablissement = id_etablissement;
    }

    public String getLibelleEtablissement() {
        return libelleEtablissement;
    }

    public void setLibelleEtablissement(String libelleEtablissement) {
        this.libelleEtablissement = libelleEtablissement;
    }

    public String getNumeroRueEtablissement() {
        return numeroRueEtablissement;
    }

    public void setNumeroRueEtablissement(String numeroRueEtablissement) {
        this.numeroRueEtablissement = numeroRueEtablissement;
    }

    public String getLibelleRueEtablissement() {
        return libelleRueEtablissement;
    }

    public void setLibelleRueEtablissement(String libelleRueEtablissement) {
        this.libelleRueEtablissement = libelleRueEtablissement;
    }

    public String getComplementAdresseEtablissement() {
        return complementAdresseEtablissement;
    }

    public void setComplementAdresseEtablissement(String complementAdresseEtablissement) {
        this.complementAdresseEtablissement = complementAdresseEtablissement;
    }

    public String getCodePostalEtablissement() {
        return codePostalEtablissement;
    }

    public void setCodePostalEtablissement(String codePostalEtablissement) {
        this.codePostalEtablissement = codePostalEtablissement;
    }

    public String getNumeroIdentification() {
        return numeroIdentification;
    }

    public void setNumeroIdentification(String numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNumMobileEtablissement() {
        return numMobileEtablissement;
    }

    public void setNumMobileEtablissement(String numMobileEtablissement) {
        this.numMobileEtablissement = numMobileEtablissement;
    }

    public String getNumFixeEtablissement() {
        return numFixeEtablissement;
    }

    public void setNumFixeEtablissement(String numFixeEtablissement) {
        this.numFixeEtablissement = numFixeEtablissement;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Etablissement{" +
                "libelleEtablissement='" + libelleEtablissement + '\'' +
                ", employe=" + employe +
                ", ville=" + ville +
                '}';
    }
}
