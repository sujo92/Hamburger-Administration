package com.example.hamburgeradministration.controller;

import com.example.hamburgeradministration.model.Menu;
import com.example.hamburgeradministration.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger LOGGER= LoggerFactory.getLogger(MenuController.class);

    @Autowired
    MenuService menuService;

    @PostMapping
    public ResponseEntity addMenu(@RequestBody Menu menu){
        return menuService.addMenu(menu);
    }

    @GetMapping
    public ResponseEntity<?> getMenu(){
        return menuService.getMenu();
    }

    @PutMapping("/{menuId}")
    public ResponseEntity updateMenu(@PathVariable String menuId ,@RequestBody Menu menu){
        return menuService.updateMenu(menuId,menu);
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity deleteMenuItem(@PathVariable String menuId ){
        return menuService.deleteMenuItem(menuId);
    }
}
