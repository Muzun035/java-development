package com.pluralsight.db;

import com.pluralsight.models.CustomerOrderHistory;
import com.pluralsight.models.SalesByYear;
import com.pluralsight.models.SalesByCategory;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private BasicDataSource dataSource;

    public DataManager(String url, String username, String password) {
        this.dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public List<CustomerOrderHistory> searchCustomerOrderHistory(String customerId) {
        List<CustomerOrderHistory> orderHistoryList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL CustOrderHist(?)}")) {
            statement.setString(1, customerId);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    String productName = results.getString("ProductName");
                    int totalQuantity = results.getInt("Total");

                    CustomerOrderHistory orderHistory = new CustomerOrderHistory(productName, totalQuantity);
                    orderHistoryList.add(orderHistory);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orderHistoryList;
    }

    public List<SalesByYear> searchSalesByYear(int year) {
        List<SalesByYear> salesByYearList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL SalesByYear(?)}")) {
            statement.setInt(1, year);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    String productName = results.getString("ProductName");
                    double totalSales = results.getDouble("TotalSales");

                    SalesByYear salesByYear = new SalesByYear(productName, totalSales);
                    salesByYearList.add(salesByYear);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return salesByYearList;
    }

    public List<SalesByCategory> searchSalesByCategory(String categoryName) {
        List<SalesByCategory> salesByCategoryList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL SalesByCategory(?)}")) {
            statement.setString(1, categoryName);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    String productName = results.getString("ProductName");
                    double totalSales = results.getDouble("TotalSales");

                    SalesByCategory salesByCategory = new SalesByCategory(productName, totalSales);
                    salesByCategoryList.add(salesByCategory);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return salesByCategoryList;
    }
}
