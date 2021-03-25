package com.unikoom.app.service;

/**
 * @author Oleg Kiselev
 */
public interface GetService<T, M> {

    M get(T id);

}
