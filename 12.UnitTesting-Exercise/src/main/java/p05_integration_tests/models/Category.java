package p05_integration_tests.models;

import java.util.HashMap;
import java.util.Map;

public class Category {

    private String name;
    private Map<String, User> users;
    private Map<String, Category> subCategories;

    public Category(String name) {
        this.name = name;
        this.users = new HashMap<>();
        this.subCategories = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public Map<String, User> getUsers() {
        return this.users;
    }

    public Map<String, Category> getSubCategories() {
        return this.subCategories;
    }

    public void addUser(User user) {
        this.users.put(user.getName(), user);
    }

    public void addSubCategory(Category category) {
        this.subCategories.put(category.getName(), category);
    }

    @Override
    public boolean equals(Object object) {
        return object != null && object instanceof Category && (object == this || this.name.equals(((Category) object).name));
    }
}