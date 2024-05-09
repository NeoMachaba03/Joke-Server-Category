package JokeServer.Category.Dao;

import JokeServer.Category.Model.Category;
import JokeServer.Database.DBConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDaoImpl extends DBConfig implements CategoryDao{

    private Connection c = getCon();

    @Override
    public void addCategory(Category category) {
        try (PreparedStatement ps = c.prepareStatement("INSERT INTO categories(CategoryName) " +
                "VALUES(?)")) {

            ps.setString(1, category.getName());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nCategory added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void retrieveCategories() {
        try (PreparedStatement ps = c.prepareStatement("SELECT * FROM categories");
             ResultSet rs = ps.executeQuery()){

            System.out.println("\nCategories: ");
            while (rs.next()){
                int categoryID = rs.getInt("CategoryID");
                String categoryName = rs.getString("CategoryName");

                System.out.println("Category ID: " + categoryID + "\tCategory Name: " + categoryName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(int categoryID, String categoryName) {
        try (PreparedStatement ps = c.prepareStatement("UPDATE categories SET CategoryName = ? WHERE CategoryID = ?")){

            ps.setString(1,categoryName);
            ps.setInt(2,categoryID);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nCategory has successfully been updated!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int categoryID) {
        try (PreparedStatement ps = c.prepareStatement("DELETE FROM categories WHERE CategoryID = ?")) {

            ps.setInt(1,categoryID);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nJoke has successfully been deleted!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
