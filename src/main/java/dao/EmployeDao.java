package dao;

import model.Employe;
import model.Pays;

import java.sql.*;
import java.util.ArrayList;

public class EmployeDao extends DAO<Employe, Integer> {
    @Override
    public Employe getByID(Integer id) {
        Employe employe = null;
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM employe where id_employe=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
               // employe = new Employe(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employe;
    }

    @Override
    public ArrayList<Employe> getAll() {
        ArrayList<Employe> liste = new ArrayList<>();
        try(Statement stmt = connexion.createStatement()) {
            String strCmd = "select nomEmploye,prenomEmploye from Employe";
            ResultSet rs = stmt.executeQuery(strCmd);
            while (rs.next()) {
                liste.add(new Employe(rs.getString(1),rs.getString(2)));
            }
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public boolean insert(Employe employe) {
        String sqlRequest = "INSERT INTO Employe VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, employe.getNomEmploye());
            preparedStatement.setString(2, employe.getPrenomEmploye());
            preparedStatement.setString(3, employe.getMailEmploye());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(employe.getDateEntreeEmploye()));
            preparedStatement.setTimestamp(5, null);
            preparedStatement.setString(6, employe.getPasswordEmploye());

            preparedStatement.setInt(7, employe.getRole().getId_role());
            preparedStatement.setInt(8, employe.getClient().getId_client());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employe employe) {
        String sqlRequest = "update Employe set nomEmploye = ?, prenomEmploye = ?," +
                "mailEmploye = ?, dateEntreeEmploye = ?, dateSortieEmploye = ?" +
                "passwordEmploye = ?"+
                "where id_employe = ?";
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,employe.getNomEmploye());
            preparedStatement.setString(2,employe.getPrenomEmploye());
            preparedStatement.setString(3,employe.getMailEmploye());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(employe.getDateEntreeEmploye()));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(employe.getDateSortieEmploye()));
            preparedStatement.setString(6, employe.getPasswordEmploye());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    @Override
    public boolean delete(Employe employe) {
        String sqlRequest = "delete from Employe where id_employe = ?";
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest)) {
            preparedStatement.setInt(1,employe.getId_employe());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}