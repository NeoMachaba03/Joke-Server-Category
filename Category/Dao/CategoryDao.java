package JokeServer.Category.Dao;

import JokeServer.Category.Model.Category;

public interface CategoryDao {

    void addCategory(Category category);
    void retrieveCategories();
    void updateCategory(int categoryID, String categoryName);
    void deleteCategory(int categoryID);
}
