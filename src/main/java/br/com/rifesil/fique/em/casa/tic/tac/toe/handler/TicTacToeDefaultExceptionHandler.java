package br.com.rifesil.fique.em.casa.tic.tac.toe.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.rifesil.fique.em.casa.tic.tac.toe.dto.ResponseDTO;
import br.com.rifesil.fique.em.casa.tic.tac.toe.error.CustomNotFoundException;

@RestControllerAdvice
public class TicTacToeDefaultExceptionHandler {

	@ExceptionHandler(CustomNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(CustomNotFoundException ex) {
		ResponseDTO responseMsg = new ResponseDTO(false, ex.getMessage());
		return new ResponseEntity(responseMsg, HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ResponseDTO responseMsg = new ResponseDTO(false, ex.getMessage());
        return new ResponseEntity(responseMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
