package br.com.rifesil.fique.em.casa.tic.tac.toe.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.rifesil.fique.em.casa.tic.tac.toe.dto.ResponseDTO;
import br.com.rifesil.fique.em.casa.tic.tac.toe.error.CustomNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class TicTacToeDefaultExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CustomNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(CustomNotFoundException ex) {
		log.error(ex.getMessage());
		ResponseDTO responseMsg = new ResponseDTO(false, ex.getMessage());
		return new ResponseEntity(responseMsg, HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    	log.error(ex.getMessage());
        ResponseDTO responseMsg = new ResponseDTO(false, ex.getMessage());
        return new ResponseEntity(responseMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
    	log.error(ex.getMessage());
    	final List<String> errors = new ArrayList<String>();
        ResponseDTO responseMsg = new ResponseDTO(false, "");
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getRejectedValue() + ": " + error.getDefaultMessage());
        }
        for (String erro : errors) {
        	responseMsg.setMessage(responseMsg.getMessage() + erro + ": ");
        }
        return new ResponseEntity(responseMsg, headers, status);
    }
}
