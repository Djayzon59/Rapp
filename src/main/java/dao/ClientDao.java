package dao;

import model.Client;
import model.Pays;
import model.Role;
import model.Ville;

import java.sql.*;
import java.util.ArrayList;

public class ClientDao extends DAO<Client, Integer> {
    @Override
    public Client getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Client> getAll() {
        return null;
    }

    @Override
    public boolean insert(Client client) {
        String sqlRequest = "INSERT INTO Client VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, client.getDenominationSociale());
            preparedStatement.setString(2, client.getMailClient());
            preparedStatement.setString(3, client.getNumeroRueCLient());
            preparedStatement.setString(4, client.getLibelleRueClient());
            preparedStatement.setString(5, client.getComplementAdresseClient());
            preparedStatement.setString(6, client.getCodePostalClient());
            preparedStatement.setString(7, client.getNumeroTva());
            preparedStatement.setString(8, client.getNumTelClient());
            preparedStatement.setString(9, client.getPassword());
            preparedStatement.setInt(10, client.getRole().getId_role());
            preparedStatement.setInt(11, client.getVille().getId_ville());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Client client) {
        String sqlRequest = "update Client set denominationSociale = ?, mailClient = ?," +
                "numeroRueClient = ?, libelleRueClient = ?, completmentAdresseClient = ?" +
                "codePostalClient = ?, numeroTva = ?, numTelClient = ?" +
                "where id_client = ?";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, client.getDenominationSociale());
            preparedStatement.setString(2, client.getMailClient());
            preparedStatement.setString(3, client.getNumeroRueCLient());
            preparedStatement.setString(4, client.getLibelleRueClient());
            preparedStatement.setString(5, client.getComplementAdresseClient());
            preparedStatement.setString(6, client.getCodePostalClient());
            preparedStatement.setString(7, client.getNumeroTva());
            preparedStatement.setString(8, client.getNumTelClient());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean delete(Client objet) {
        return false;
    }

    public Client searchConnexion(String email, String password) {
        Client client = null;

        String strCmd = "SELECT c.id_client, c.denominationSociale,c.mailClient,c.numeroRueClient,c.libelleRueClient,c.complementAdresseClient,c.codePostalClient,c.numeroTva,c.numTelClient,c.passwordClient,r.id_role, r.libelleRole, v.id_ville, v.libelleVille FROM Client as c JOIN Role as r ON c.id_role = r.id_role JOIN Ville as v ON c.id_ville = v.id_ville WHERE mailClient = ? AND passwordClient = ? ";
        PreparedStatement stmt;
        try  {
            stmt = connexion.prepareStatement(strCmd);
            stmt.setString(1,email);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                client = new Client(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10),
                        new Role(rs.getInt(11), rs.getString(12)), new Ville(rs.getInt(13), rs.getString(14)));

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return client;
    }
}
