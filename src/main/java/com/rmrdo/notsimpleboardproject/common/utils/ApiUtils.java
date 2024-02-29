package com.rmrdo.notsimpleboardproject.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

public class ApiUtils {
	public static <T> ApiResult<T> success(T response) {
		return new ApiResult<>(true, response, null);
	}

	public static <T> ApiResult<?> error(Throwable throwable, HttpStatus status) {
		return new ApiResult<>(false, null, new ApiError(throwable, status));
	}

	public static <T> ApiResult<?> error(String message, HttpStatus status) {
		return new ApiResult<>(false, null, new ApiError(message, status));
	}

	@Getter
	@ToString
	public static class ApiError {
		private final String message;
		private final int    status;

		ApiError(Throwable throwable, HttpStatus status) {
			this(throwable.getMessage(), status);
		}

		ApiError(String message, HttpStatus status) {
			this.message = message;
			this.status  = status.value();
		}
	}

	@AllArgsConstructor
	@Getter
	@ToString
	public static class ApiResult<T> {
		private final boolean           success;
		private final T                 response;
		private final ApiUtils.ApiError error;
	}
}