package io.expense.tracker.app.service;

import io.expense.tracker.app.entity.CustomUser;
import io.expense.tracker.app.model.CustomUserDTO;

public interface CustomUserService {
    public CustomUserDTO createNewUser(CustomUserDTO customUserDTO);
    public boolean deleteExisingUser(Long id);

    CustomUserDTO updateExistingUser(Long id, CustomUserDTO customUserDTO);
}
