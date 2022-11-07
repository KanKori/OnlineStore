package com.orpheus.OnlineStore.exeption;

/**
 * Class for performing NotFoundException
 * @author Anastasiia Voshchenko
 * @since 2022
 * @version %I%, %G%
 */
public class NotFoundException extends Exception {

    /**
     * Exception that tell us that thing don't finded
     * @param message input message
     */
    public NotFoundException(String message) {
        super(message);
    }
}
