package com.example.orm.conrtoller;

import com.example.orm.RoleService;
import com.example.orm.entity.Customer;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityController {

    private RoleService service;

    public SecurityController(RoleService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String loginEndpoint() {
        return "Login!";
    }

    @GetMapping("/read")
    @RolesAllowed("ROLE_READ")
    public String read() {
        return "READ!";
    }

    @GetMapping("/write")
    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    public String write() {
        return "WRITE!";
    }

    @GetMapping("/admin")
    @Secured({"ROLE_ADMIN", "ROLE_DELETE"})
    public String adminEndpoint() {
        return "Admin!";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "User!";
    }

    @GetMapping("/all")
    public String allRolesEndpoint() {
        return "All Roles!";
    }

    @GetMapping("/delete")
    @PostAuthorize("returnObject.name == authentication.principal.username")
    public Customer deleteEndpoint(@RequestParam (value = "name", required = false) String name) {
        return service.getUserName();
    }
}
