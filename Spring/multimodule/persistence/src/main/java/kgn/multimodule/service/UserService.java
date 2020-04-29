package kgn.multimodule.service;

import kgn.multimodule.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User add(User user);
    User update(User user);
    void delete(Long id);
}
