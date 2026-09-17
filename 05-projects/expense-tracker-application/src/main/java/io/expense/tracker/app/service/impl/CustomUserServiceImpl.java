package io.expense.tracker.app.service.impl;

import io.expense.tracker.app.converter.CustomUserConverter;
import io.expense.tracker.app.entity.CustomUser;
import io.expense.tracker.app.model.CustomUserDTO;
import io.expense.tracker.app.repository.CustomUserRepository;
import io.expense.tracker.app.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserServiceImpl implements CustomUserService {

    private CustomUserRepository customUserRepository;
    private CustomUserConverter customUserConverter;

    @Autowired
    CustomUserServiceImpl(CustomUserRepository invokeCustomUserRepository,
                          CustomUserConverter iCustomUserConverter){
        customUserRepository = invokeCustomUserRepository;
        customUserConverter = iCustomUserConverter;
    }

    @Override
    public CustomUserDTO createNewUser(CustomUserDTO customUserDTO) {

        CustomUser customUser = customUserConverter.convertDtoToEntity(customUserDTO);
        customUserRepository.save(customUser);

        CustomUserDTO customUserDTO1 = customUserConverter.convertEntityToDto(customUser);
        return customUserDTO1;
    }

    @Override
    public boolean deleteExisingUser(Long id) {
        Optional<CustomUser> customUser = customUserRepository.findById(id);
        if(customUser.isPresent()){
            customUserRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CustomUserDTO updateExistingUser(Long id, CustomUserDTO customUserDTO) {
        CustomUser customUser = customUserConverter.updateExistingUser(id, customUserDTO);
        customUserRepository.save(customUser);
        CustomUserDTO customUserDTO1 = customUserConverter.convertEntityToDto(customUser);
        return customUserDTO1;
    }
}
