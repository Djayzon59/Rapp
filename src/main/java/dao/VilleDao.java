package dao;

import model.Employe;
import model.Etablissement;
import model.Ville;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VilleDao extends DAO <Ville, Integer> {
    @Override
    public Ville getByID(Integer id) {
        Ville ville = null;
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM etablissement where id_etablissement=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ville = new Ville(rs.getInt(1),rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ville;
    }

    @Override
    public ArrayList<Ville> getAll() {
        return null;
    }

    @Override
    public boolean insert(Ville ville) {
        String sqlRequest = "INSERT INTO Ville VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, ville.getLibelleVille());
            preparedStatement.setInt(2, ville.getPays().getId_pays());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next())
                ville.setId_ville(rs.getInt(1));
            rs.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Ville objet) {
        return false;
    }

    @Override
    public boolean delete(Ville ville) {
        String sqlRequest = "delete from Ville where id_ville = ? ";
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest)) {
            preparedStatement.setInt(1,ville.getId_ville());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            return false;
        }

    }


    public Ville getByNom(String libelleVille){
        Ville ville = null;
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id_ville,libelleVille FROM Ville where libelleVille=?");
            preparedStatement.setString(1, libelleVille);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ville = new Ville(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return ville;
    }

    public int getIdVille(Ville ville){
        try{
            String sqlRequest = "SELECT id_ville FROM Ville WHERE libelleVille = ? AND id_pays = ?";
            try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest)) {
                preparedStatement.setString(1, ville.getLibelleVille());
                preparedStatement.setInt(2, ville.getPays().getId_pays());

                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("id_ville");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int counterEtablissementByVille(Ville ville) {
        int counter = 0;
        try {
            String sqlRequest = "SELECT COUNT(*) AS nombreEtablissements " +
                    "FROM Etablissement AS E " +
                    "JOIN VILLE AS V ON E.id_ville = V.id_ville " +
                    "where V.id_ville = ? ";
            try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest)) {
                preparedStatement.setInt(1, ville.getId_ville());
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        counter = rs.getInt("nombreEtablissements");
                        System.out.println(counter);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return counter;

    }

}
