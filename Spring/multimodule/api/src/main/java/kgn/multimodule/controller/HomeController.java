package kgn.multimodule.controller;

import kgn.multimodule.model.User;
import kgn.multimodule.repository.UserRepository;
import kgn.multimodule.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class HomeController {

    private UserService service;

    public HomeController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUser() {
        return service.getAll();
    }

    @PostMapping
    public User add(@RequestBody User user) {
        return service.add(user);
    }

    @GetMapping(path = "/{id}")
    public User getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping(path = "/{id}")
    public void  delete(@PathVariable Long id) {
        service.delete(id);
    }
}
