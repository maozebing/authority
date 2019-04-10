package com.ybx.authority.api;

import com.ybx.authority.common.viewentity.ViewMenu;
import com.ybx.authority.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/menu")
public class MenuApi {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity<List<ViewMenu>> listMenu() {
        return ResponseEntity.ok(menuService.listMenu());
    }

}
