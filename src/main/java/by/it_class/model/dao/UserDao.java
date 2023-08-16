package by.it_class.model.dao;

import by.it_class.model.db.ConnectionManager;
import by.it_class.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String QUERY_NAME = "SELECT id, name, email FROM user WHERE name LIKE ?";//LIKE- совпадение (игнорит регистр)
    private static final String QUERY_ID = "SELECT * FROM user WHERE id >= ? AND id <= ?";

    public User findByName(String name) {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(QUERY_NAME)) {
            ps.setString(1, name);
            final ResultSet rs = ps.executeQuery();//executeQuery - когда запрос начинается с SELECT,
            //на остальные запросы executeUpdate (когда что-то меняем).
            if (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                return new User(id, name, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findByIds(int from, int to) {
        List<User> users = new ArrayList<>();
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(QUERY_ID)) {
            ps.setInt(1, from);
            ps.setInt(2, to);
            final ResultSet rs = ps.executeQuery();//executeQuery - когда запрос начинается с SELECT,
            //на остальные запросы executeUpdate (когда что-то меняем).
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                users.add(new User(id, name, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
