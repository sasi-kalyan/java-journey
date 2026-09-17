package io.expense.tracker.app.dao;

import io.expense.tracker.app.entity.CustomUser;
import io.expense.tracker.app.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDAO {

    private CustomUserRepository customUserRepository;

    @Autowired
    public CustomUserDAO(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }

    public CustomUser getExistingUser(Long id){
        Optional<CustomUser> optionalCustomUser = customUserRepository.findById(id);
        return optionalCustomUser.get();
    }
}
