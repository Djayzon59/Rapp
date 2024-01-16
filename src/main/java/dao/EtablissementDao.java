package dao;

import model.Employe;
import model.Etablissement;
import model.Ville;

import java.sql.*;
import java.util.ArrayList;

public class EtablissementDao extends DAO<Etablissement, Integer> {
    @Override
    public Etablissement getByID(Integer id) {
        Etablissement etablissement = null;
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM etablissement where id_etablissement=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                etablissement = new Etablissement(rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6),
                        rs.getString(7), rs.getString(10), rs.getString(11));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etablissement;
    }

    @Override
    public ArrayList<Etablissement> getAll() {
        ArrayList<Etablissement> liste = new ArrayList<>();
        try(Statement stmt = connexion.createStatement()) {
            String strCmd = "select E.*, Em.nomEmploye, V.libelleVille " +
                    "from Etablissement as E " +
                    "join Employe as Em on E.id_employe = Em.id_employe " +
                    "join Ville as V on E.id_ville = V.id_ville";
            ResultSet rs = stmt.executeQuery(strCmd);
            while (rs.next()) {
                liste.add(new Etablissement(rs.getInt(1),rs.getString(2)
                ,rs.getString(3), rs.getString(4),rs.getString(5)
                ,rs.getString(6),rs.getString(7),rs.getString(8)
                ,rs.getString(9),rs.getString(10),rs.getString(11)
                ,new Employe(rs.getString(15)), new Ville(rs.getInt(14),rs.getString(16))));
            }
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public boolean insert(Etablissement etablissement) {

        String sqlRequest = "INSERT INTO Etablissement VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, etablissement.getId_etablissement());

            preparedStatement.setString(2, etablissement.getLibelleEtablissement());
            preparedStatement.setString(3, etablissement.getNumeroRueEtablissement());
            preparedStatement.setString(4, etablissement.getLibelleRueEtablissement());
            preparedStatement.setString(5, etablissement.getComplementAdresseEtablissement());
            preparedStatement.setString(6, etablissement.getCodePostalEtablissement());
            preparedStatement.setString(7, etablissement.getNumeroIdentification());
            preparedStatement.setString(8, etablissement.getLatitude());
            preparedStatement.setString(9, etablissement.getLongitude());
            preparedStatement.setString(10, etablissement.getNumMobileEtablissement());
            preparedStatement.setString(11, etablissement.getNumFixeEtablissement());
            preparedStatement.setInt(12, etablissement.getEmploye().getId_employe());
            preparedStatement.setInt(13, etablissement.getClient().getId_client());
            preparedStatement.setInt(14  , etablissement.getVille().getId_ville());


            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Etablissement etablissement) {
        String sqlRequest = "update Etablissement set libelleEtablissement = ?, numeroRueEtablissement = ?," +
                "libelleRueEtablissement = ?, complementAdresseEtablissement = ?, codePostalEtablissement = ?" +
                ", numeroIdentification = ?, latitude = ?, longitude = ?, numMobileEtablissement = ?, numFixeEtablissement = ?" +
                ", id_employe = ?, id_client = ?, id_ville = ?"+
                "where id_etablissement = ?";
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(14,etablissement.getId_etablissement());

            preparedStatement.setString(1, etablissement.getLibelleEtablissement());
            preparedStatement.setString(2, etablissement.getNumeroRueEtablissement());
            preparedStatement.setString(3, etablissement.getLibelleRueEtablissement());
            preparedStatement.setString(4, etablissement.getComplementAdresseEtablissement());
            preparedStatement.setString(5, etablissement.getCodePostalEtablissement());
            preparedStatement.setString(6,etablissement.getNumeroIdentification());
            preparedStatement.setString(7, etablissement.getLatitude());
            preparedStatement.setString(8, etablissement.getLongitude());
            preparedStatement.setString(9, etablissement.getNumMobileEtablissement());
            preparedStatement.setString(10, etablissement.getNumFixeEtablissement());
            preparedStatement.setInt(11, etablissement.getEmploye().getId_employe());
            preparedStatement.setInt(12,7);
            preparedStatement.setInt(13, etablissement.getVille().getId_ville());

            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    @Override
    public boolean delete(Etablissement etablissement) {
        String sqlRequest = "delete from Etablissement where id_etablissement = ?";
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest)) {
            preparedStatement.setInt(1,etablissement.getId_etablissement());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
