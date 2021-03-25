package com.unikoom.app.controller;

import com.unikoom.app.dto.UserDtoFull;
import com.unikoom.app.dto.UserDtoPreview;
import com.unikoom.app.dto.converter.Converter;
import com.unikoom.app.model.User;
import com.unikoom.app.service.CreateService;
import com.unikoom.app.service.GetListService;
import com.unikoom.app.service.GetService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Oleg Kiselev
 */
@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor(onConstructor_ = {@Autowired, @NonNull})
public class UserController {

    private final CreateService<User> createService;
    private final GetService<Long, User> getService;
    private final GetListService<User> getListService;
    private final Converter<User, UserDtoFull> userDtoFullConverter;
    private final Converter<User, UserDtoPreview> userDtoPreviewConverter;

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDtoFull> create(@RequestBody UserDtoFull dtoFull) {

        User user = userDtoFullConverter.toModel(dtoFull);
        createService.create(user);
        UserDtoFull createdUser = userDtoFullConverter.toDto(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDtoFull> get(@PathVariable Long id) {

        UserDtoFull user = userDtoFullConverter.toDto(getService.get(id));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDtoPreview>> getList() {

        List<UserDtoPreview> list = getListService.getList().stream()
                .map(userDtoPreviewConverter::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
