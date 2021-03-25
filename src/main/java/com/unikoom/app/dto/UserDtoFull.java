package com.unikoom.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unikoom.app.model.types.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author Oleg Kiselev
 */
@Data
@AllArgsConstructor
public class UserDtoFull {

    private Long id;

    private String login;

    private String fullName;

    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;

    private Sex sex;

}
