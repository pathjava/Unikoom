package com.unikoom.app.dto.converter.impl;

import com.unikoom.app.dto.UserDtoFull;
import com.unikoom.app.dto.converter.Converter;
import com.unikoom.app.model.User;
import com.unikoom.app.service.GetService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Oleg Kiselev
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired, @NonNull})
public class UserDtoFullConverterImpl implements Converter<User, UserDtoFull> {

    private final GetService<Long, User> userGetService;

    @Override
    public User toModel(UserDtoFull dto) {
        if (dto == null)
            return null;
        else if (dto.getId() == null) {
            return new User(
                    null,
                    dto.getLogin(),
                    dto.getFullName(),
                    dto.getEmail(),
                    dto.getBirthday(),
                    dto.getSex()
            );
        } else {
            User user = userGetService.get(dto.getId());
            user.setLogin(dto.getLogin());
            user.setFullName(dto.getFullName());
            user.setEmail(dto.getEmail());
            user.setBirthday(dto.getBirthday());
            user.setSex(dto.getSex());
            return user;
        }
    }

    @Override
    public UserDtoFull toDto(User model) {
        if (model == null)
            return null;
        else {
            return new UserDtoFull(
                    model.getId(),
                    model.getLogin(),
                    model.getFullName(),
                    model.getEmail(),
                    model.getBirthday(),
                    model.getSex()
            );
        }
    }
}
