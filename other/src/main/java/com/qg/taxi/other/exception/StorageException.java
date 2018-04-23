package com.qg.taxi.other.exception;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/4/23
 * No struggle, talent how to match the willfulness.
 * Description:
 */
public class StorageException extends RuntimeException {

    StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
