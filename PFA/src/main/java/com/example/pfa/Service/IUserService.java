package com.example.pfa.Service;

import com.example.pfa.Model.PoliceT;
import com.example.pfa.Model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    User save(User article);
    void deleteById(Long id);
    Optional<User> findById(Long id);
    User update(User stade);
}
