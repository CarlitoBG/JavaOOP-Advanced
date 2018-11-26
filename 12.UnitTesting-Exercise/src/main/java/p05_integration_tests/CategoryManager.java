package p05_integration_tests;

import p05_integration_tests.models.Category;
import p05_integration_tests.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class CategoryManager {

    private Map<String, Category> categoryByName;
    private Map<String, User> userByName;

    CategoryManager() {
        this.categoryByName = new HashMap<>();
        this.userByName = new HashMap<>();
    }

    Map<String, Category> getCategoryByName() {
        return this.categoryByName;
    }

    Map<String, User> getUserByName() {
        return this.userByName;
    }

    void addCategory(Category category) {
        this.categoryByName.put(category.getName(), category);
    }

    void addUser(User user) {
        this.userByName.put(user.getName(), user);
    }

    void removeCategory(String categoryName) {
        if (!this.categoryByName.containsKey(categoryName)) {
            throw new IllegalArgumentException("Category does not exists!");
        }

        Category category = this.categoryByName.get(categoryName);
        assignUsersToSubCategory(category);

        this.categoryByName.remove(categoryName);
    }


    void assignChildCategoryToParentCategory(String childCategoryName, String parentCategoryName) {
        if (!this.categoryByName.containsKey(childCategoryName) || !this.categoryByName.containsKey(parentCategoryName)) {
            throw new IllegalArgumentException("Both categories should be available!");
        }

        Category childCategory = this.categoryByName.get(childCategoryName);
        Category parentCategory = this.categoryByName.get(parentCategoryName);

        parentCategory.addSubCategory(childCategory);
    }

    void assignUserToCategory(String username, String categoryName) {
        if (!this.userByName.containsKey(username) || !this.categoryByName.containsKey(categoryName)) {
            throw new IllegalArgumentException("Both username and category name should be available!");
        }

        User user = this.userByName.get(username);
        Category category = this.categoryByName.get(categoryName);

        user.addCategory(category);
        category.addUser(user);
    }

    private void assignUsersToSubCategory(Category category) {
        Collection<Category> subCategories = category.getSubCategories().values();
        if (!subCategories.isEmpty()) {
            Collection<User> users = category.getUsers().values();
            for (User user : users) {
                user.removeCategory(category.getName());

                for (Category subCategory : subCategories) {
                    user.addCategory(subCategory);
                    subCategory.addUser(user);
                }
            }
        }
    }
}