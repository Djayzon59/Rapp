package dao;

import model.Client;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientDao extends DAO<Client, Integer>{
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
    public boolean update(Client objet) {
        return false;
    }

    @Override
    public boolean delete(Client objet) {
        return false;
    }
}
