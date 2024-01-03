package dao;
import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO <T, TId> {

    protected Connection connexion;

    public DAO(){
        connexion = RDTBConnect.getInstance();
    }



    public abstract T getByID(TId id);
    public abstract ArrayList<T> getAll();
    //public abstract ArrayList <T> getLike (TSearch objet);
    public abstract boolean insert (T objet);
    public abstract boolean update (T objet);
    public abstract boolean delete (T objet);

}
