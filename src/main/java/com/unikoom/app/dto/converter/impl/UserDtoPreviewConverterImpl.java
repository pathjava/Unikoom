package com.unikoom.app.dto.converter.impl;

import com.unikoom.app.dto.UserDtoPreview;
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
public class UserDtoPreviewConverterImpl implements Converter<User, UserDtoPreview> {

    private final GetService<Long, User> userGetService;

    @Override
    public User toModel(UserDtoPreview dto) {
        if (dto == null)
            return null;
        else {
            return userGetService.get(dto.getId());
        }
    }

    @Override
    public UserDtoPreview toDto(User model) {
        if (model == null)
            return null;
        else {
            return new UserDtoPreview(
                    model.getId(),
                    model.getLogin(),
                    model.getFullName()
            );
        }
    }
}
