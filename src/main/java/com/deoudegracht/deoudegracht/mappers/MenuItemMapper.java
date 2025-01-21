package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.MenuItemRequestDTO;
import com.deoudegracht.deoudegracht.dtos.MenuItemResponseDTO;
import com.deoudegracht.deoudegracht.models.MenuItem;

public class MenuItemMapper {
    static public MenuItemResponseDTO mapMenuItemToMenuItemResponseDTO(MenuItem menuItem) {
        return new MenuItemResponseDTO(menuItem.getId(), menuItem.getName(), menuItem.getDescription(), menuItem.getPrice(), menuItem.getCategory(), menuItem.getRecipeId());
    }
    static public MenuItem mapMenuItemRequestDTOToMenuItem(MenuItemRequestDTO menuItemRequestDTO){
        return new MenuItem(menuItemRequestDTO.getName(), menuItemRequestDTO.getDescription(), menuItemRequestDTO.getPrice(), menuItemRequestDTO.getCategory(), menuItemRequestDTO.getRecipeId());
    }
    static public MenuItem mapMenuItemRequestDTOToMenuItem(MenuItemRequestDTO menuItemRequestDTO, long id){
        MenuItem menuItem =   new MenuItem(menuItemRequestDTO.getName(), menuItemRequestDTO.getDescription(), menuItemRequestDTO.getPrice(), menuItemRequestDTO.getCategory(), menuItemRequestDTO.getRecipeId());
        menuItem.setId(id);
        return menuItem;
    }
}
