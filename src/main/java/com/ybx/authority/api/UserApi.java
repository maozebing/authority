package com.ybx.authority.api;

import com.ybx.authority.common.viewentity.ViewUser;
import com.ybx.authority.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<ViewUser>> listUser() {
        return ResponseEntity.ok(userService.listUser());
    }

    @PostMapping()
    public ResponseEntity<Void> addUser(@RequestBody ViewUser viewUser){
        userService.addUser(viewUser);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Void> updateUser(@RequestBody ViewUser viewUser){
        userService.updateUser(viewUser);
        return new ResponseEntity(HttpStatus.OK);
    }

}
