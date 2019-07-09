package com.wd.springboot.springbootshoping.exception;


/**
 * ClassName:ServiceException
 * Package:com.wd.ssm.exception
 * Description:
 *  异常处理
 * @Date:2019/5/2 0002 19:24
 * @Author:王迪
 */
public class ServiceException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ServiceException(String message) {
        super(message);
    }
}
