/**
 * 
 */
package pet.store.controller.error;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {

	private enum LogStatus {
		STACK_TRACE, MESSAGE_ONLY
	}

	@Data
	private class ExceptionMessage {
		private String message;
		private String statusReason;
		private String timestamp;
		private String uri;
		private int statusCode;
	}

	// Handle PUT request sent to invalid pet store ID
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExceptionMessage handleNoSuchElementException(NoSuchElementException ex, WebRequest webRequest) {
		return buildExceptionMessage(ex, HttpStatus.NOT_FOUND, webRequest, LogStatus.MESSAGE_ONLY);
	}
	
	// Previous, simple NoSuchElementException handler:
//	@ExceptionHandler(NoSuchElementException.class)
//	@ResponseStatus(code = HttpStatus.NOT_FOUND)
//	public Map<String, String> handleNoSuchElementException(NoSuchElementException ex) {
//		// log the error
//		log.error("Pet store not found.");
//		return Map.of("message", ex.toString());
//	}

	// Handle bad request
	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionMessage handleIllegalStateException(IllegalStateException ex, WebRequest webRequest) {
		return buildExceptionMessage(ex, HttpStatus.BAD_REQUEST, webRequest, LogStatus.MESSAGE_ONLY);
	}

	/**
	 * @param ex
	 * @param badRequest
	 * @param webRequest
	 * @param messageOnly
	 * @return
	 */
	private ExceptionMessage buildExceptionMessage(Exception ex, HttpStatus status, WebRequest webRequest,
			LogStatus logStatus) {
		String message = ex.toString();
		String statusReason = status.getReasonPhrase();
		int statusCode = status.value();
		String uri = null;
		String timestamp = ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);

		// get the URI from the request
		if (webRequest instanceof ServletWebRequest servletWebRequest) {
			uri = servletWebRequest.getRequest().getRequestURI();
		}

		// log the request error
		if (logStatus == LogStatus.MESSAGE_ONLY) {
			log.error("Exception: {}", ex.toString());
		} else {
			log.error("Exception: ", ex); // log entire stack trace
		}

		ExceptionMessage exceptionMessage = new ExceptionMessage();

		// set exceptionMessage fields
		exceptionMessage.setMessage(message);
		exceptionMessage.setStatusReason(statusReason);
		exceptionMessage.setStatusCode(statusCode);
		exceptionMessage.setUri(uri);
		exceptionMessage.setTimestamp(timestamp);

		return exceptionMessage;
	}

}
