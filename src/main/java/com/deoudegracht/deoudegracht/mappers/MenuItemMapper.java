package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.MenuItemRequestDTO;
import com.deoudegracht.deoudegracht.dtos.MenuItemResponseDTO;
import com.deoudegracht.deoudegracht.models.MenuItem;
import com.deoudegracht.deoudegracht.services.FileStorageService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class MenuItemMapper {
    private final FileStorageService fileStorageService;

    public MenuItemMapper(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    public MenuItemResponseDTO mapMenuItemToMenuItemResponseDTO(MenuItem menuItem) {
        return new MenuItemResponseDTO(menuItem.getId(), menuItem.getName(), menuItem.getDescription(), 
            menuItem.getPrice(), menuItem.getCategory(), menuItem.getRecipeId(), menuItem.getImagePath());
    }

    public MenuItem mapMenuItemRequestDTOToMenuItem(MenuItemRequestDTO menuItemRequestDTO) throws IOException {
        MultipartFile image = menuItemRequestDTO.getImage();
        String imagePath = null;
        if (image != null && !image.isEmpty()) {
            imagePath = fileStorageService.storeFile(image);
        }
        return new MenuItem(menuItemRequestDTO.getName(), menuItemRequestDTO.getDescription(), 
            menuItemRequestDTO.getPrice(), menuItemRequestDTO.getCategory(), 
            menuItemRequestDTO.getRecipeId(), imagePath);
    }

    public MenuItem mapMenuItemRequestDTOToMenuItem(MenuItemRequestDTO menuItemRequestDTO, long id) throws IOException {
        MenuItem menuItem = mapMenuItemRequestDTOToMenuItem(menuItemRequestDTO);
        menuItem.setId(id);
        return menuItem;
    }
}
