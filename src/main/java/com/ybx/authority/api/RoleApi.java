package com.ybx.authority.api;

import com.ybx.authority.common.viewentity.ViewRole;
import com.ybx.authority.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleApi {

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public ResponseEntity<List<ViewRole>> listRole(){
        return ResponseEntity.ok(roleService.listRole());
    }

    @PostMapping()
    public ResponseEntity<Void> addRole(@RequestBody ViewRole viewRole){
        roleService.addRole(viewRole);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Void> updateRole(@RequestBody ViewRole viewRole){
        roleService.updateRole(viewRole);
        return new ResponseEntity(HttpStatus.OK);
    }

}
