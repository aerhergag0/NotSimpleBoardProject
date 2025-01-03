package com.rmrdo.notsimpleboardproject.exception;

import com.rmrdo.notsimpleboardproject.common.utils.ApiUtils;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Log4j2
public class GeneralExceptionHandler {

	private ResponseEntity<ApiUtils.ApiResult<?>> newResponse(Throwable throwable, HttpStatus status) {
		return newResponse(throwable.getMessage(), status);
	}

	private ResponseEntity<ApiUtils.ApiResult<?>> newResponse(String message, HttpStatus status) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return new ResponseEntity<>(ApiUtils.error(message, status), headers, status);
	}

	@ExceptionHandler(value = {
			NoHandlerFoundException.class,
			NotFoundException.class
	})
	public ResponseEntity<?> handleNotFoundException(Exception e) {
		return newResponse(e, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UnauthorizedException.class)
	public ResponseEntity<?> handleUnauthorizedException(Exception e) {
		return newResponse(e, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = {
			IllegalArgumentException.class,
			IllegalStateException.class,
			ConstraintViolationException.class,
			MethodArgumentNotValidException.class
	})
	public ResponseEntity<?> handleBadRequestException(Exception e) {
		log.debug("Bad request exception occurred: {}", e.getMessage(), e);
		if (e instanceof MethodArgumentNotValidException) {
			return newResponse(
					((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage(),
					HttpStatus.BAD_REQUEST
			);
		}
		return newResponse(e, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = HttpMediaTypeException.class)
	public ResponseEntity<?> handleHttpMediaTypeException(Exception e) {
		return newResponse(e, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> handleMethodNotAllowedException(Exception e) {
		return newResponse(e, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(value = {Exception.class, RuntimeException.class})
	public ResponseEntity<?> handleException(Exception e) {
		log.error("Unexpected exception occurred: {}", e.getMessage(), e);
		return newResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
