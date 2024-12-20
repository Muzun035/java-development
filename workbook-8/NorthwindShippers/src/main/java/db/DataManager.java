package db;

import models.Shipper;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("p@ssw0rd");
    }

    public static int addShipper(String name, String phone) {
        String query = "INSERT INTO shippers (companyName, phone) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static List<Shipper> getAllShippers() {
        List<Shipper> shippers = new ArrayList<>();
        String query = "SELECT shipperId, companyName, phone FROM shippers";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("shipperId");
                String name = resultSet.getString("companyName");
                String phone = resultSet.getString("phone");
                shippers.add(new Shipper(id, name, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shippers;
    }

    public static void updateShipperPhone(int shipperId, String newPhone) {
        String query = "UPDATE shippers SET phone = ? WHERE shipperId = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newPhone);
            statement.setInt(2, shipperId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteShipper(int shipperId) {
        String query = "DELETE FROM shippers WHERE shipperId = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, shipperId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}