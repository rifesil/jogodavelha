package br.com.rifesil.fique.em.casa.tic.tac.toe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
/** Data Transfer Object (DTO) representing Jogo responses. */
public class ResponseDTO {

  private Boolean won;
  private String message;
 
}
