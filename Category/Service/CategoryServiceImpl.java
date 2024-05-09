package JokeServer.Category.Service;

import JokeServer.Category.Dao.CategoryDaoImpl;
import JokeServer.Category.Model.Category;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CategoryServiceImpl implements CategoryService{

    private CategoryDaoImpl categoryDao = new CategoryDaoImpl();
    private Scanner input = new Scanner(System.in);

    @Override
    public void addCategory() {
        while (true){
            try {
                System.out.print("\nEnter the category name: ");
                String name = input.nextLine();

                Category category = new Category(0,name);

                categoryDao.addCategory(category);
                break;
            }catch (InputMismatchException e){
                System.out.println("\nInvalid entry!!! Please try again");
            }
        }


    }

    @Override
    public void retrieveCategories() {
        categoryDao.retrieveCategories();
    }

    @Override
    public void updateCategory() {
        while (true){
            try {
                System.out.print("\nEnter the category ID: ");
                int id = Integer.parseInt(input.nextLine());

                System.out.println("\nEnter the updated version: ");
                String update = input.nextLine();

                categoryDao.updateCategory(id,update);
                break;
            }catch (InputMismatchException e){
                System.out.println("\nInvalid entry!!! Please try again");
            }
        }
    }

    @Override
    public void deleteCategory() {
        while (true){
            try {
                System.out.print("\nEnter the category ID: ");
                int id = Integer.parseInt(input.nextLine());

                categoryDao.deleteCategory(id);
                break;
            }catch (InputMismatchException e){
                System.out.println("\nInvalid entry!!! Please try again");
            }
        }
    }
}
