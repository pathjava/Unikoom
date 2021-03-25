package com.unikoom.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Oleg Kiselev
 */
@Data
@AllArgsConstructor
public class UserDtoPreview {

    private Long id;

    private String login;

    private String fullName;

}
