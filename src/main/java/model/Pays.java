package model;

public class Pays {

    private int id_pays;
    private String libellePays;
    private String regexNumeroTva;
    private String regexIdentifiant;
    private String regexTelephonePortable;
    private String regexTelephoneFixe;


    public Pays() {
    }

    public Pays(int id_pays, String libellePays, String regexNumeroTva, String regexIdentifiant, String regexTelephonePortable, String regexTelephoneFixe) {
        this.id_pays = id_pays;
        this.libellePays = libellePays;
        this.regexNumeroTva = regexNumeroTva;
        this.regexIdentifiant = regexIdentifiant;
        this.regexTelephonePortable = regexTelephonePortable;
        this.regexTelephoneFixe = regexTelephoneFixe;
    }

    public Pays(String libellePays, String regexNumeroTva, String regexIdentifiant, String regexTelephonePortable, String regexTelephoneFixe) {
        this.libellePays = libellePays;
        this.regexNumeroTva = regexNumeroTva;
        this.regexIdentifiant = regexIdentifiant;
        this.regexTelephonePortable = regexTelephonePortable;
        this.regexTelephoneFixe = regexTelephoneFixe;
    }

    public int getId_pays() {
        return id_pays;
    }

    public void setId_pays(int id_pays) {
        this.id_pays = id_pays;
    }

    public String getLibellePays() {
        return libellePays;
    }

    public void setLibellePays(String libellePays) {
        this.libellePays = libellePays;
    }

    public String getRegexNumeroTva() {
        return regexNumeroTva;
    }

    public void setRegexNumeroTva(String regexNumeroTva) {
        this.regexNumeroTva = regexNumeroTva;
    }

    public String getRegexIdentifiant() {
        return regexIdentifiant;
    }

    public void setRegexIdentifiant(String regexIdentifiant) {
        this.regexIdentifiant = regexIdentifiant;
    }

    public String getRegexTelephonePortable() {
        return regexTelephonePortable;
    }

    public void setRegexTelephonePortable(String regexTelephonePortable) {
        this.regexTelephonePortable = regexTelephonePortable;
    }

    public String getRegexTelephoneFixe() {
        return regexTelephoneFixe;
    }

    public void setRegexTelephoneFixe(String regexTelephoneFixe) {
        this.regexTelephoneFixe = regexTelephoneFixe;
    }

    @Override
    public String toString() {
        return  libellePays;
    }
}
