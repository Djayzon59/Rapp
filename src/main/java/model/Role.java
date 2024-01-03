package model;

public class Role {

    private int id_role;
    private String libelleRole;


    public Role() {
    }

    public Role(String libelleRole) {
        this.libelleRole = libelleRole;
    }

    public Role(int id_role, String libelleRole) {
        this.id_role = id_role;
        this.libelleRole = libelleRole;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getLibelleRole() {
        return libelleRole;
    }

    public void setLibelleRole(String libelleRole) {
        this.libelleRole = libelleRole;
    }
}
