package com.unikoom.app.service.impl;

import com.unikoom.app.model.User;
import com.unikoom.app.repository.UserRepository;
import com.unikoom.app.service.CreateService;
import com.unikoom.app.service.GetListService;
import com.unikoom.app.service.GetService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.String.format;

/**
 * @author Oleg Kiselev
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor_ = {@Autowired, @NonNull})
public class UserServiceImpl implements GetService<Long, User>, CreateService<User>, GetListService<User> {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void create(User model) {
        userRepository.save(model);
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(format("User id=%s not found", id)));
    }

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }
}
