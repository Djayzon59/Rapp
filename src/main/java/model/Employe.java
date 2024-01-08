package model;

import java.time.LocalDateTime;

public class Employe {
    private int id_employe;
    private String nomEmploye;
    private String prenomEmploye;
    private String mailEmploye;
    private LocalDateTime dateEntreeEmploye;
    private LocalDateTime dateSortieEmploye;
    private String passwordEmploye;
    private Role role;
    private Client client;


    public Employe() {
        role = new Role();
        client=new Client();
    }

    public Employe(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public Employe(String nomEmploye, String prenomEmploye) {
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
    }

    public Employe(int id_employe, String nomEmploye, String prenomEmploye) {
        this.id_employe = id_employe;
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
    }

    public Employe(String nomEmploye, String prenomEmploye, String mailEmploye, LocalDateTime dateEntreeEmploye, LocalDateTime dateSortieEmploye) {
        this.nomEmploye = nomEmploye;
        this.prenomEmploye = prenomEmploye;
        this.mailEmploye = mailEmploye;
        this.dateEntreeEmploye = dateEntreeEmploye;
        this.dateSortieEmploye = dateSortieEmploye;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }

    public String getMailEmploye() {
        return mailEmploye;
    }

    public void setMailEmploye(String mailEmploye) {
        this.mailEmploye = mailEmploye;
    }

    public LocalDateTime getDateEntreeEmploye() {
        return dateEntreeEmploye;
    }

    public void setDateEntreeEmploye(LocalDateTime dateEntreeEmploye) {
        this.dateEntreeEmploye = dateEntreeEmploye;
    }

    public LocalDateTime getDateSortieEmploye() {
        return dateSortieEmploye;
    }

    public void setDateSortieEmploye(LocalDateTime dateSortieEmploye) {
        this.dateSortieEmploye = dateSortieEmploye;
    }

    public String getPasswordEmploye() {
        return passwordEmploye;
    }

    public void setPasswordEmploye(String passwordEmploye) {
        this.passwordEmploye = passwordEmploye;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return nomEmploye  + " " + prenomEmploye ;
    }
}
