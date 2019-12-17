package com.xavier.theordersapi.resource;

import com.xavier.theordersapi.model.UserAccount;
import com.xavier.theordersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserAccount> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserAccount findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserAccount save(@Valid @RequestBody UserAccount userAccount) {
        return userService.save(userAccount);
    }

    @PutMapping("/{id}")
    public UserAccount update(@PathVariable Long id, @Valid @RequestBody UserAccount userAccount) {
        userAccount.setUserId(id);
        return userService.save(userAccount);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
