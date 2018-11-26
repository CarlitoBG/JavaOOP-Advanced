package p05_integration_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p05_integration_tests.models.Category;
import p05_integration_tests.models.User;

import java.lang.reflect.Field;
import java.util.Map;

public class CategoryManagerTest {

    private static final String USER_PESHO = "Pesho";
    private static final String USER_GOSHO = "Gosho";
    private static final String USER_STAMAT = "Stamat";
    private static final String USER_DRAGAN = "Dragan";
    private static final String CATEGORY_SPORT = "SPORT";
    private static final String CATEGORY_WORK = "WORK";
    private static final String CATEGORY_VIDEO_GAMES = "VIDEO GAMES";
    private static final String CATEGORY_CARS = "CARS";
    private static final String CHILD_CATEGORY_FOOTBALL = "FOOTBALL";

    private static final User[] USERS = new User[] {new User(USER_PESHO), new User(USER_GOSHO), new User(USER_STAMAT)};
    private static final Category[] CATEGORIES = new Category[] {
            new Category(CATEGORY_SPORT), new Category(CATEGORY_WORK), new Category(CATEGORY_VIDEO_GAMES)};

    private CategoryManager categoryManager;

    @Before
    public void init() {
        this.categoryManager = new CategoryManager();
        for (User user : USERS) {
            this.categoryManager.addUser(user);
        }

        for (Category category : CATEGORIES) {
            this.categoryManager.addCategory(category);
        }
    }

    @Test
    public void testAddingUsersToCategoryShouldWorkCorrectly() {
        this.categoryManager.addUser(new User(USER_DRAGAN));

        int actualNumberOfUsers = this.categoryManager.getUserByName().values().size();
        int expectedUsersAfterSuccessfulAddOfUser = 4;

        Assert.assertEquals(expectedUsersAfterSuccessfulAddOfUser, actualNumberOfUsers);
    }

    @Test
    public void testAddingCategoriesShouldWorkCorrectly() {
        this.categoryManager.addCategory(new Category(CATEGORY_CARS));

        int actualNumberOfCategories = this.categoryManager.getCategoryByName().values().size();
        int expectedCategoriesAfterSuccessfulAddOfCategory = 4;

        Assert.assertEquals(expectedCategoriesAfterSuccessfulAddOfCategory, actualNumberOfCategories);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAssigningUserToCategoryShouldAddUserToCategoryCorrectly() throws NoSuchFieldException, IllegalAccessException {

        this.categoryManager.assignUserToCategory(USER_PESHO, CATEGORY_SPORT);

        Field categoryByName = CategoryManager.class.getDeclaredField("categoryByName");
        categoryByName.setAccessible(true);
        Category categorySport = ((Map<String, Category>) categoryByName.get(this.categoryManager)).get(CATEGORY_SPORT);

        Assert.assertEquals(true, categorySport.getUsers().containsKey(USER_PESHO));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAssigningUserToCategoryShouldAddCategoryToUserCorrectly() throws NoSuchFieldException, IllegalAccessException {

        this.categoryManager.assignUserToCategory(USER_PESHO, CATEGORY_SPORT);

        Field userByName = CategoryManager.class.getDeclaredField("userByName");
        userByName.setAccessible(true);
        User userPesho = ((Map<String, User>) userByName.get(this.categoryManager)).get(USER_PESHO);

        Assert.assertEquals(true, userPesho.getCategories().containsKey(CATEGORY_SPORT));
    }

    @Test
    public void testAssigningChildCategoryShouldAddSubcategoryToParentCategorySuccessfully() {

        this.categoryManager.addCategory(new Category(CHILD_CATEGORY_FOOTBALL));
        this.categoryManager.assignChildCategoryToParentCategory(CHILD_CATEGORY_FOOTBALL, CATEGORY_SPORT);

        Map<String, Category> subCategories = this.categoryManager.getCategoryByName().get(CATEGORY_SPORT).getSubCategories();

        Assert.assertEquals(true, subCategories.containsKey(CHILD_CATEGORY_FOOTBALL));
    }

    @Test
    public void testRemovingParentCategoryShouldRemoveCategoryFromCategoriesCorrectly() {

        this.categoryManager.removeCategory(CATEGORY_SPORT);

        boolean doesCategoriesContainCategorySport = this.categoryManager.getCategoryByName().containsKey(CATEGORY_SPORT);

        Assert.assertEquals(false, doesCategoriesContainCategorySport);
    }

    @Test
    public void testRemovingParentCategoryShouldRemoveCategoryFromGivenUserCorrectly() {

        this.categoryManager.removeCategory(CATEGORY_SPORT);

        User userPesho = this.categoryManager.getUserByName().get(USER_PESHO);
        boolean doesUserPeshoHaveCategorySport = userPesho.getCategories().containsKey(CATEGORY_SPORT);

        Assert.assertEquals(false, doesUserPeshoHaveCategorySport);
    }

    @Test
    public void testRemovingParentCategoryShouldAddItsChildCategoryToCategoriesOfUserSuccessfully() {

        this.categoryManager.addCategory(new Category(CHILD_CATEGORY_FOOTBALL));
        this.categoryManager.assignChildCategoryToParentCategory(CHILD_CATEGORY_FOOTBALL, CATEGORY_SPORT);
        this.categoryManager.assignUserToCategory(USER_PESHO, CATEGORY_SPORT);
        this.categoryManager.removeCategory(CATEGORY_SPORT);

        User userPesho = this.categoryManager.getUserByName().get(USER_PESHO);
        boolean doesUserPeshoHaveChildCategoryFootball = userPesho.getCategories().containsKey(CHILD_CATEGORY_FOOTBALL);

        Assert.assertEquals(true, doesUserPeshoHaveChildCategoryFootball);
    }

    @Test
    public void testRemovingParentCategoryShouldAssignItsUsersToChildCategory() {

        this.categoryManager.addCategory(new Category(CHILD_CATEGORY_FOOTBALL));
        this.categoryManager.assignChildCategoryToParentCategory(CHILD_CATEGORY_FOOTBALL, CATEGORY_SPORT);
        this.categoryManager.assignUserToCategory(USER_PESHO, CATEGORY_SPORT);
        this.categoryManager.removeCategory(CATEGORY_SPORT);

        Map<String, User> usersOfChildCategory = this.categoryManager.getCategoryByName().get(CHILD_CATEGORY_FOOTBALL).getUsers();
        boolean doesChildCategoryFootballHaveUserPesho = usersOfChildCategory.containsKey(USER_PESHO);

        Assert.assertEquals(true, doesChildCategoryFootballHaveUserPesho);
    }
}