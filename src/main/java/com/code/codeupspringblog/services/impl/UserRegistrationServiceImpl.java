package com.code.codeupspringblog.services.impl;

import com.code.codeupspringblog.models.Group;
import com.code.codeupspringblog.models.User;
import com.code.codeupspringblog.repositories.UserGroupRepository;
import com.code.codeupspringblog.repositories.UserRepository;
import com.code.codeupspringblog.services.EmailService;
import com.code.codeupspringblog.services.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
@AllArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;
    private final UserGroupRepository groupRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public void register(User user) throws DuplicateKeyException {
        if(checkIfUserExist(user.getEmail())){
            throw new DuplicateKeyException("User already exists for this email");
            // TODO: throw new UserAlreadyExistException("User already exists for this email");
        }
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        String hash = passwordEncoder.encode(user.getPassword());
        userEntity.setPassword(hash);
        updateUserGroup(userEntity);
        userRepository.save(userEntity);
        sendRegistrationConfirmationEmail(userEntity);
    }

    private boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    private void sendRegistrationConfirmationEmail(User userEntity) {
        emailService.sendWelcomeEmail(
            userEntity,
            "Welcome Created [%s]".formatted(userEntity.getFullName()),
            "You have been registered"
        );
    }

    private void updateUserGroup(User userEntity){
        Group group = groupRepository.findByCode("user");
        userEntity.setUserGroup(group);
    }
}