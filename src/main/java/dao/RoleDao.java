package dao;

import model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RoleDao extends DAO <Role,Integer> {
    @Override
    public Role getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Role> getAll() {
        ArrayList<Role> liste = new ArrayList<>();
        String sqlRequest = "select id_role, libelleRole from Role";
        try (Statement statement = connexion.createStatement()){
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()){
                liste.add(new Role(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Role role)  {
        String sqlRequest = "insert into Role (libelleRole) values (?)";
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,role.getLibelleRole());
            preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Role objet) {
        return false;
    }

    @Override
    public boolean delete(Role role) {
        String sqlRequest = "delete from Role where id_role =?";
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest)){
            preparedStatement.setInt(1, role.getId_role());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
