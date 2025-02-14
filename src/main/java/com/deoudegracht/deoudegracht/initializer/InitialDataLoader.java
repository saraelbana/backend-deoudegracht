package com.deoudegracht.deoudegracht.initializer;

import com.deoudegracht.deoudegracht.models.*;
import com.deoudegracht.deoudegracht.services.EmployeeService;
import com.deoudegracht.deoudegracht.services.MenuItemService;
import com.deoudegracht.deoudegracht.services.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class InitialDataLoader implements CommandLineRunner {
    private final EmployeeService employeeService;
    private final PasswordEncoder passwordEncoder;
    private final RecipeService recipeService;
    private final MenuItemService menuItemService;
    public InitialDataLoader(EmployeeService employeeService, PasswordEncoder passwordEncoder, RecipeService recipeService, MenuItemService menuItemService) {
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
        this.recipeService = recipeService;
        this.menuItemService = menuItemService;
    }
    @Override
    public void run(String... args) {
        //initial users, admin and chef
        if (employeeService.getAllEmployees().isEmpty()) {
            User adminUser = new User(
                    "admin",
                    "admin123",
                    "Admin",
                    "User",
                    "admin@restaurant.com",
                    "1234567890",
                    Role.ADMIN
            );
            User chefUser = new User(
                    "chef",
                    "admin123",
                    "Chef",
                    "User",
                    "chef@restaurant.com",
                    "1234567890",
                    Role.CHEF
            );
            User employeeUser = new User(
                    "employee",
                    "admin123",
                    "Employee",
                    "User",
                    "employee@restaurant.com",
                    "1234567890",
                    Role.EMPLOYEE
            );

            Employee admin = new Employee();
            Employee chef = new Employee();
            Employee employee = new Employee();
            admin.setUser(adminUser);
            chef.setUser(chefUser);
            employee.setUser(employeeUser);
            admin.setRole(Role.ADMIN);
            chef.setRole(Role.CHEF);
            employee.setRole(Role.EMPLOYEE);
            employeeService.createEmployee(admin);
            employeeService.createEmployee(chef);
            employeeService.createEmployee(employee);
        }
        //initial recipe
        if (recipeService.getAllRecipes().isEmpty()) {
            Recipe recipe = new Recipe();
            recipe.setName("Mediterranean Falafel Bowl");
            recipe.setDescription("Fresh and flavorful falafel served with hummus and vegetables");
            recipe.setCategory(FoodCategoryType.MainCourse);

            Ingredient chickpeasIngredient = new Ingredient("Chickpeas");
            Ingredient parsleyIngredient = new Ingredient("Parsley");
            Ingredient cuminIngredient = new Ingredient("Cumin");
            Ingredient garlicIngredient = new Ingredient("Garlic");

            RecipeIngredient chickpeas = new RecipeIngredient(chickpeasIngredient, 400, "grams");
            recipe.addRecipeIngredient(chickpeas);
            RecipeIngredient parsley = new RecipeIngredient(parsleyIngredient, 30, "grams");
            recipe.addRecipeIngredient(parsley);
            RecipeIngredient cumin = new RecipeIngredient(cuminIngredient, 5, "grams");
            recipe.addRecipeIngredient(cumin);
            RecipeIngredient garlic = new RecipeIngredient(garlicIngredient, 15, "grams");
            recipe.addRecipeIngredient(garlic);

            InstructionStep step1 = new InstructionStep("Soak chickpeas overnight",recipe);
            recipe.addInstructionStep(step1);
            InstructionStep step2 = new InstructionStep("Blend with herbs and spices",recipe);
            recipe.addInstructionStep(step2);

            recipeService.createRecipe(recipe);

            //initial menuItem
            if (menuItemService.getAllMenuItems().isEmpty()) {
                MenuItem menuItem = new MenuItem();
                menuItem.setName("Falafel Bowl");
                menuItem.setDescription("Mediterranean Falafel Bowl");
                menuItem.setPrice(8.5);
                menuItem.setCategory(FoodCategoryType.MainCourse);
                menuItem.setRecipeId(1);

                menuItemService.createMenuItem(menuItem);
            }
        }
    }
}