package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.MenuItemResponseDTO;
import com.deoudegracht.deoudegracht.mappers.MenuItemMapper;
import com.deoudegracht.deoudegracht.models.MenuItem;
import com.deoudegracht.deoudegracht.repositories.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<MenuItemResponseDTO> getAllMenuItems() {
        try{
            List<MenuItemResponseDTO> menuItemResponseDTOList = new ArrayList<>();
            List <MenuItem> menuItemsList= menuItemRepository.findAll();
            for(MenuItem menuItem : menuItemsList) {
                menuItemResponseDTOList.add(new MenuItemResponseDTO(menuItem.getId(), menuItem.getName(), menuItem.getDescription(), menuItem.getPrice(),menuItem.getCategory(), menuItem.getRecipeId()));
            }
            return menuItemResponseDTOList;
        } catch (Exception e) {
            throw new RuntimeException("No menu items found");
        }
    }

    public MenuItemResponseDTO createMenuItem(MenuItem menuItem) {
        try {
            menuItemRepository.save(menuItem);
            return MenuItemMapper.mapMenuItemToMenuItemResponseDTO(menuItem);
        } catch (Exception e) {
            throw new RuntimeException("Creating menu item process failed");
        }
    }

    public MenuItem updateMenuItem(MenuItem menuItem) {
        try {
            menuItemRepository.save(menuItem);
            System.out.println("Menu Item updated, ID = " + menuItem.getId());
            return menuItem;
        } catch (Exception e) {
            throw new RuntimeException("Updating menu item process failed");
        }
    }

    public void deleteMenuItem(long id) {
        menuItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu item not found"));
        try {
            menuItemRepository.deleteById(id);
            System.out.println("Menu Item deleted");
        } catch (Exception e) {
            throw new RuntimeException("Deleting menu item process failed");
        }
    }
}
