package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.repositories.MenuItemRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }
}
