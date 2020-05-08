package kgn.multimodule.controller;

import kgn.multimodule.model.User;
import kgn.multimodule.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private UserRepository repository;

    public HomeController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> getUser() {
        return repository.findAll();
    }
}
