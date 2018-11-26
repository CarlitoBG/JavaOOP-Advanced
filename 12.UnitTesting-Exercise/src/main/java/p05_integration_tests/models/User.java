package p05_integration_tests.models;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private Map<String, Category> categories;

    public User(String name) {
        this.name = name;
        this.categories = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Category> getCategories() {
        return this.categories;
    }

    public void addCategory(Category category) {
        this.categories.put(category.getName(), category);
    }

    public void removeCategory(String categoryName) {
        this.categories.remove(categoryName);
    }
}