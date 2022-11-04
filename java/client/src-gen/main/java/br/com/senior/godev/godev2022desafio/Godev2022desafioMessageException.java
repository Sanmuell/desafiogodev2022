/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.ErrorPayload;

/**
 * RuntimeException com informações do payload de erro vindo da mensageria
 */
public class Godev2022desafioMessageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorCategory category;
	private String errorCode;

	public Godev2022desafioMessageException(ErrorCategory category, String errorCode, String message, Throwable e) {
        super(message, e);
		this.category = category;
		this.errorCode = errorCode;
    }

	public Godev2022desafioMessageException(ErrorCategory category, String message, String errorCode) {
        super(message);
		this.category = category;
		this.errorCode = errorCode;
    }

	public ErrorCategory getCategory() {
		return category;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public ErrorPayload getErrorPayload() {
		return new ErrorPayload(getMessage(), errorCode);
	}
}

