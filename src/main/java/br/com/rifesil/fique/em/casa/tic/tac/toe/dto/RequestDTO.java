package br.com.rifesil.fique.em.casa.tic.tac.toe.dto;

import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class RequestDTO {

	@Size(min = 3, max = 3, message = "A lista deve ter o tamanho de 3 posições")
	private List<@Size(min = 3, max = 3, message = "O campo deve ter exatamente 3 posições") 
				 @Pattern(regexp = "[@OX\\\\s]*", message = "Deve ter apenas O ou X") String> jogo;

	public List<String> getJogo() {
		return jogo;
	}

	public void setJogo(List<String> jogo) {
		this.jogo = jogo;
	}
	/**
   * Builder for the class.
   *
   * @param otherInfo of the new jogo.
   */
  @JsonCreator
  public RequestDTO(@JsonProperty("jogo") List<String> jogo) {
    this.jogo = jogo;
  }


}
