package com.exercise;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * This exception is used to indicate a situation where an invalid request parameter 
 * is provided. For example, -1 is given as an input. If later on we see more of such
 * exception, they may be put in a separate package.
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Input Number cannot be negative")
public class InvalidRequestParameterException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
