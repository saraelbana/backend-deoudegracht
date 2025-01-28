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
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }
    @GetMapping("/{id}")
    ResponseEntity<MenuItemResponseDTO> getMenuItemById(@PathVariable long id){
        try{
            return ResponseEntity.ok().body(MenuItemMapper.mapMenuItemToMenuItemResponseDTO(menuItemService.getMenuItemById(id)));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    ResponseEntity<List<MenuItemResponseDTO>> getAllMenuItems(){
        try{
            return ResponseEntity.ok().body(menuItemService.getAllMenuItems());
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    ResponseEntity<?> createMenuItem(@RequestBody MenuItemRequestDTO menuItemRequestDTO){
        try{
            MenuItem newToCreateMenuItem;
            try {
                newToCreateMenuItem = MenuItemMapper.mapMenuItemRequestDTOToMenuItem(menuItemRequestDTO);
            } catch (Exception e) {
                return ResponseEntity.unprocessableEntity().body("Entered Menu Item Data is not correct");
            }
            MenuItemResponseDTO newCreatedMenuItemresponseDto = menuItemService.createMenuItem(newToCreateMenuItem);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newCreatedMenuItemresponseDto.getId()).toUriString());

            return ResponseEntity.created(uri).body(newCreatedMenuItemresponseDto);
        }
        catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("Creating new Menu Item failed");
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateMenuItem(@PathVariable long id, @RequestBody MenuItemRequestDTO menuItemRequestDTO){
        try{
            return ResponseEntity.ok().body(MenuItemMapper.mapMenuItemToMenuItemResponseDTO(menuItemService.updateMenuItem(MenuItemMapper.mapMenuItemRequestDTOToMenuItem(menuItemRequestDTO,id))));
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
