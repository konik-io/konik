package io.konik.sdk.http;

public class BadRequestException extends RuntimeException {

	private final ErrorResponse errorResponse;

	public BadRequestException(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}
}
