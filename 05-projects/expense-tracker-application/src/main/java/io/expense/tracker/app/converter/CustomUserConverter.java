package io.expense.tracker.app.converter;

import io.expense.tracker.app.dao.CustomUserDAO;
import io.expense.tracker.app.entity.CustomUser;
import io.expense.tracker.app.model.CustomUserDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomUserConverter {

    private CustomUserDAO customUserDAO;

    public CustomUserConverter(CustomUserDAO customUserDAO) {
        this.customUserDAO = customUserDAO;
    }

    public CustomUser convertDtoToEntity(CustomUserDTO customUserDTO){
        CustomUser customUser = new CustomUser();
        customUser.setDob(customUserDTO.getDob());
        customUser.setName(customUserDTO.getName());
        customUser.setEmail(customUserDTO.getEmail());
        customUser.setMobile(customUserDTO.getMobile());
        customUser.setAltMobile(customUserDTO.getAltMobile());

        return customUser;
    }

    public CustomUserDTO convertEntityToDto(CustomUser customUser){
        CustomUserDTO customUserDTO = new CustomUserDTO();

        customUserDTO.setId(customUser.getId());
        customUserDTO.setDob(customUser.getDob());
        customUserDTO.setName(customUser.getName());
        customUserDTO.setEmail(customUser.getEmail());
        customUserDTO.setMobile(customUser.getMobile());
        customUserDTO.setAltMobile(customUser.getAltMobile());

        return customUserDTO;
    }

    public CustomUser updateExistingUser(Long id, CustomUserDTO customUserDTO){
        CustomUser customUser = customUserDAO.getExistingUser(id);

        if(customUserDTO.getName() != null && !customUserDTO.equals(customUser.getName())){
            customUser.setName(customUserDTO.getName());
        }

        if(customUserDTO.getEmail() != null && !customUserDTO.equals(customUser.getEmail())){
            customUser.setEmail(customUserDTO.getEmail());
        }

        if(customUserDTO.getDob() != null && !customUserDTO.equals(customUser.getDob())){
            customUser.setDob(customUserDTO.getDob());
        }

        if(customUserDTO.getMobile() != null && !customUserDTO.equals(customUser.getMobile())){
            customUser.setMobile(customUserDTO.getMobile());
        }

        if(customUserDTO.getAltMobile() != null && !customUserDTO.equals(customUser.getAltMobile())){
            customUser.setAltMobile(customUserDTO.getAltMobile());
        }

        return customUser;
    }
}
