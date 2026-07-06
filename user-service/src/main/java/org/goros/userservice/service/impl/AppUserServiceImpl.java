package org.goros.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.goros.userservice.entity.response.AppUserResponse;
import org.goros.userservice.exception.UserNotFoundException;
import org.goros.userservice.repository.AppUserRepository;
import org.goros.userservice.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    public final AppUserRepository appUserRepository;
    public final ModelMapper modelMapper;

    @Override
    public List<AppUserResponse> getAllUsers() {
        return appUserRepository.findAll().stream().map(user -> modelMapper.map(user,AppUserResponse.class)).toList();
    }

    @Override
    public AppUserResponse getUserById(UUID userId) {
        return modelMapper.map(appUserRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found")), AppUserResponse.class);
    }

    @Override
    public AppUserResponse getUserByEmailOrUsername(String identifier) {
        return modelMapper.map(appUserRepository.findByIdentifier(identifier).orElseThrow(() -> new UserNotFoundException("User not found")), AppUserResponse.class);
    }
}