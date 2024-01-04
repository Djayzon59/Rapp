package dao;

import model.Client;
import model.Etablissement;

public class DaoFactory {

    public static RoleDao getRoleDAO(){return new RoleDao();}
    public static PaysDao getPaysDAO(){return new PaysDao();}
    public static VilleDao getVilleDAO(){return new VilleDao();}
    public static ClientDao getClientDAO(){return new ClientDao();}
    public static EmployeDao getEmployeDAO(){return new EmployeDao();}

    public static EtablissementDao getEtablissementDAO(){return new EtablissementDao();}
}
