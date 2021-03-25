package com.unikoom.app.dto.converter;

/**
 * @author Oleg Kiselev
 */
public interface Converter<M, D> {

    M toModel(D dto);

    D toDto(M model);

}
