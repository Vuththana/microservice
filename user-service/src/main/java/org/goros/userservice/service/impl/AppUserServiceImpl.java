package org.goros.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.goros.userservice.entity.model.AppUser;
import org.goros.userservice.entity.request.AppUserRequest;
import org.goros.userservice.entity.request.UpdateUserRequest;
import org.goros.userservice.entity.response.AppUserResponse;
import org.goros.userservice.exception.UserNotFoundException;
import org.goros.userservice.repository.AppUserRepository;
import org.goros.userservice.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    public final AppUserRepository appUserRepository;
    public final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<AppUserResponse> getAllUsers() {
        return appUserRepository.findAll().stream().map(user -> modelMapper.map(user,AppUserResponse.class)).toList();
    }

    @Override
    public AppUserResponse getUserById(UUID userId) {
        return modelMapper.map(appUserRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found")), AppUserResponse.class);
    }

    @Override
    public List<AppUserResponse> getUserByEmailOrUsername(String identifier) {
        return appUserRepository.findByIdentifier(identifier).orElseThrow(() -> new UserNotFoundException("User not found")).stream().map(user-> modelMapper.map(user, AppUserResponse.class)).toList();
    }

    @Transactional
    @Override
    public void deleteUserById(UUID userId) {
        if(appUserRepository.findById(userId).isPresent()) {
            appUserRepository.deleteUserById(userId);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public AppUserResponse addUser(AppUserRequest request) {
        AppUser user = modelMapper.map(request, AppUser.class);
        user.setUsername(request.getFirstName() + "." + request.getLastName() + ThreadLocalRandom.current().nextInt(1000, 10000));
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        appUserRepository.save(user);
        return modelMapper.map(user, AppUserResponse.class);
    }

    @Transactional
    @Override
    public void updateUserById(UUID userId, UpdateUserRequest request) {
        AppUser user = appUserRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
    }

    @Override
    public AppUserResponse getUserByIdentifier(String identifier) {
        AppUser user = appUserRepository
                .getByIdIdentifier(identifier)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found")
                );
        return modelMapper.map(user, AppUserResponse.class);
    }
}