package com.github.aelmod.geekhub.homework3;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Created by Євгеній on 06.11.2016.
 */
public class InventoryJdbc implements Inventorization {
    public static final String DB_URL = "jdbc:mysql://localhost/geekhub-hw3";
    public static final String DB_USER = "aelmod";
    public static final String DB_PASS = "AlD19372046";

    private Connection connection = null;

    private Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        }
        return connection;
    }

    @Override
    public BigDecimal getInventoryValueSum() {
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT sum(price) as sum FROM products");
            resultSet.first();
            return resultSet.getBigDecimal("sum");
        } catch (SQLException e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        }
    }

    @Override
    public void addCategory(Category category) {
        if (category.getCategoryId() != 0)
            throw new IllegalArgumentException("Category has specified id, it means that category already is created");
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO categories(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.executeUpdate();
            ResultSet idRS = preparedStatement.getGeneratedKeys();
            idRS.first();
            category.setCategoryId(idRS.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategories(Category category, Category... categories) {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute("DELETE FROM `categories` WHERE `id`=" + category.getCategoryId());
            category.setCategoryId(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category[] getAllCategories() {
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM categories");
            resultSet.last();
            Category[] categories = new Category[resultSet.getRow()];
            resultSet.beforeFirst();
            int i = 0;
            while (resultSet.next()) {
                categories[i++] = new Category(resultSet.getInt("id"), resultSet.getString("name"));
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("Smth wrong");
        }
    }

    @Override
    public void addProduct(Product product) {
        if (product.getProductId() != 0)
            throw new IllegalArgumentException("Product has specified id, it means that product already is created");
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO products(name, category_id, price, current_count) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getCategory().getCategoryId());
            preparedStatement.setBigDecimal(3, product.getPrice());
            preparedStatement.setInt(4, product.getCurrentCount());
            preparedStatement.executeUpdate();
            ResultSet idRS = preparedStatement.getGeneratedKeys();
            idRS.first();
            product.setProductId(idRS.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProducts(Product product, Product... products) {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute("DELETE FROM `products` WHERE `id`=" + product.getProductId());
            product.setProductId(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product[] getAllProducts() {
        return getAllProductsByCategory(null);
    }

    @Override
    public Product[] getAllProductsByCategory(Category category) {
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products" + (category != null ? " where category_id=" + category.getCategoryId() : ""));
            resultSet.last();
            Product[] products = new Product[resultSet.getRow()];
            resultSet.beforeFirst();
            int i = 0;
            while (resultSet.next()) {
                if (category == null) {
                    ResultSet resultSet1 = getConnection().createStatement().executeQuery("SELECT * FROM categories WHERE `id`=" + resultSet.getInt("category_id"));
                    resultSet1.first();
                    category = new Category(resultSet1.getInt("id"), resultSet1.getString("name"));
                }
                products[i++] = new Product(resultSet.getInt("id"), resultSet.getString("name"), category, resultSet.getBigDecimal("price"), resultSet.getInt("current_count"));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Product[0];
    }

    public void productCurrentCountUpdate(Product product) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE products SET current_count = ? WHERE `id`= ?")) {
            preparedStatement.setInt(1, product.getCurrentCount());
            preparedStatement.setInt(2, product.getProductId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void productSingOutUpdate(Product product) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE products SET current_count = ?, quantity_on_hand = ? WHERE `id`= ?")) {
            preparedStatement.setInt(1, product.getCurrentCount());
            preparedStatement.setInt(2, product.getQuantityOnHand());
            preparedStatement.setInt(3, product.getProductId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
