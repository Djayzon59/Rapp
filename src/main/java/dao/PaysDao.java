package dao;

import model.Pays;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaysDao extends DAO<Pays, Integer>{
    @Override
    public Pays getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Pays> getAll() {
        ArrayList<Pays> liste = new ArrayList<>();
        try(Statement stmt = connexion.createStatement()) {
            String strCmd = "select id_pays,libellePays,regexNumeroTva,regexIdentifiant,regexTelephonePortable,regexTelephoneFixe from Pays";
            ResultSet rs = stmt.executeQuery(strCmd);
            while (rs.next()) {
                liste.add(new Pays(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public boolean insert(Pays pays) {
        String sqlRequest = "INSERT INTO Pays VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, pays.getLibellePays());
            preparedStatement.setString(2, pays.getRegexNumeroTva());
            preparedStatement.setString(3, pays.getRegexIdentifiant());
            preparedStatement.setString(4, pays.getRegexTelephonePortable());
            preparedStatement.setString(5, pays.getRegexTelephoneFixe());
            preparedStatement.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Pays pays) {
        String sqlRequest = "update Pays set libellePays = ?, regexNumeroTva = ?," +
                "regexIdentifiant = ?, regexTelephonePortable = ?, regexTelephoneFixe = ?" +
                "where id_pays = ?";
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,pays.getLibellePays());
            preparedStatement.setString(2,pays.getRegexNumeroTva());
            preparedStatement.setString(3,pays.getRegexIdentifiant());
            preparedStatement.setString(4, pays.getRegexTelephonePortable());
            preparedStatement.setString(5, pays.getRegexTelephoneFixe());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public boolean delete(Pays pays) {
        String sqlRequest = "delete from Pays where id_pays = ?";
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest)) {
            preparedStatement.setInt(1,pays.getId_pays());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            return false;
        }

    }
}
