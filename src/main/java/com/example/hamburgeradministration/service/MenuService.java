package com.example.hamburgeradministration.service;

import com.example.hamburgeradministration.model.Menu;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Lob;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MenuService {

    @Autowired
    MongoRepository menuRepository;


    public ResponseEntity addMenu(Menu menu) {
        if(menuRepository.findById(menu.getId()).isPresent()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }else {
            menuRepository.save(menu);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
    }

    public ResponseEntity<List<Menu>> getMenu() {
        List<Menu> menuList=  menuRepository.findAll();
        List<Menu> sortedMenuList =menuList.stream()
                .sorted(Comparator.comparing(Menu::getCategory).thenComparing(Menu::getName))
                .collect(Collectors.toList());
        return new ResponseEntity<>(sortedMenuList, HttpStatus.OK);
    }

    public ResponseEntity updateMenu(String menuId, Menu menu) {
        Optional<Menu> menuItem = menuRepository.findById(menuId);
        if(menuItem.isEmpty()) {
            return new ResponseEntity((HttpStatus.NOT_FOUND));
        }
        menuItem.ifPresent( item ->{
                item.setName(menu.getName());
                item.setPrice(menu.getPrice());
                item.setCombo(menu.isCombo());
                item.setComboPrice(menu.getComboPrice());
                item.setCategory(menu.getCategory());
                menuRepository.save(item);
        });
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity deleteMenuItem(String menuId) {
        Optional<Menu> menuItem = menuRepository.findById(menuId);
        if(menuItem.isPresent()){
            menuRepository.deleteById(menuId);
            return  new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
