package dao;

import model.Ville;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VilleDao extends DAO <Ville, Integer> {
    @Override
    public Ville getByID(Integer integer) {
        return null;
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
    public boolean delete(Ville objet) {
        return false;
    }
}
