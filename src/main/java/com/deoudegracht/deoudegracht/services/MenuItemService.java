package com.deoudegracht.deoudegracht.services;


import com.deoudegracht.deoudegracht.models.MenuItem;
import com.deoudegracht.deoudegracht.repositories.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItem getMenuItemById(long id) {
        try {
            return menuItemRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Menu item not found");
        }
    }

    public List<MenuItem> getAllMenuItems() {
        try {
            return menuItemRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("No menu items found");
        }
    }

    public MenuItem createMenuItem(MenuItem menuItem) {
        String menuItemName = menuItem.getName();
        if(menuItemRepository.findByName(menuItemName).isPresent()) {
            throw new RuntimeException("Menu item already exists with the name: " + menuItemName);
        }
        try {
            return menuItemRepository.save(menuItem);
        } catch (Exception e) {
            throw new RuntimeException("Creating menu item process failed");
        }
    }

    public MenuItem updateMenuItem(MenuItem menuItem) {
        try {
            menuItemRepository.save(menuItem);

            return menuItem;
        } catch (Exception e) {
            throw new RuntimeException("Updating menu item process failed");
        }
    }

    public void deleteMenuItem(long id) {
        menuItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu item not found"));
        try {
            menuItemRepository.deleteById(id);

        } catch (Exception e) {
            throw new RuntimeException("Deleting menu item process failed");
        }
    }
}
