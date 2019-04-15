package com.ybx.authority.api;

import com.ybx.authority.common.viewentity.ViewLoginUser;
import com.ybx.authority.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/permission")
public class PermissionApi {

    @Autowired
    private PermissionService permissionService;

    @PostMapping(value = "/login")
    public ResponseEntity<ViewLoginUser> login(@RequestBody ViewLoginUser viewLoginUser) throws Exception {
        return ResponseEntity.ok(permissionService.login(viewLoginUser.getCode(),viewLoginUser.getPassword()));
    }
}
