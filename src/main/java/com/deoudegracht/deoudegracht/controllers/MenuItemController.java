package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.MenuItemRequestDTO;
import com.deoudegracht.deoudegracht.dtos.MenuItemResponseDTO;
import com.deoudegracht.deoudegracht.mappers.MenuItemMapper;
import com.deoudegracht.deoudegracht.models.MenuItem;
import com.deoudegracht.deoudegracht.services.MenuItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/menu-items")
public class MenuItemController {
    private final MenuItemService menuItemService;
    private final MenuItemMapper menuItemMapper;

    public MenuItemController(MenuItemService menuItemService, MenuItemMapper menuItemMapper) {
        this.menuItemService = menuItemService;
        this.menuItemMapper = menuItemMapper;
    }
    @GetMapping("/{id}")
    ResponseEntity<MenuItemResponseDTO> getMenuItemById(@PathVariable long id){
        try{
            return ResponseEntity.ok().body(menuItemMapper.mapMenuItemToMenuItemResponseDTO(menuItemService.getMenuItemById(id)));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    ResponseEntity<List<MenuItemResponseDTO>> getAllMenuItems() {
        try {
            List<MenuItem> menuItems = menuItemService.getAllMenuItems();
            List<MenuItemResponseDTO> dtos = menuItems.stream()
                .map(menuItemMapper::mapMenuItemToMenuItemResponseDTO)
                .toList();
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(consumes = {"multipart/form-data"})
    ResponseEntity<?> createMenuItem(MenuItemRequestDTO menuItemRequestDTO){
        try{
            MenuItem newToCreateMenuItem;
            try {
                newToCreateMenuItem = menuItemMapper.mapMenuItemRequestDTOToMenuItem(menuItemRequestDTO);
            } catch (Exception e) {
                return ResponseEntity.unprocessableEntity().body("Entered Menu Item Data is not correct");
            }
            
            MenuItem createdMenuItem = menuItemService.createMenuItem(newToCreateMenuItem);
            MenuItemResponseDTO responseDto = menuItemMapper.mapMenuItemToMenuItemResponseDTO(createdMenuItem);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + responseDto.getId()).toUriString());

            return ResponseEntity.created(uri).body(responseDto);
        }
        catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("Creating new Menu Item failed");
        }
    }
    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    ResponseEntity<?> updateMenuItem(@PathVariable long id, @ModelAttribute MenuItemRequestDTO menuItemRequestDTO){
        try{
            MenuItem menuItemToUpdate = menuItemMapper.mapMenuItemRequestDTOToMenuItem(menuItemRequestDTO, id);
            MenuItem updatedMenuItem = menuItemService.updateMenuItem(menuItemToUpdate);
            return ResponseEntity.ok().body(menuItemMapper.mapMenuItemToMenuItemResponseDTO(updatedMenuItem));
        }
        catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("Updating Menu Item failed");
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteMenuItem(@PathVariable long id){
        try{
            menuItemService.deleteMenuItem(id);
            return ResponseEntity.ok().body("Menu Item deleted successfully");
        }
        catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("Deleting Menu Item failed");
        }
    }
}
