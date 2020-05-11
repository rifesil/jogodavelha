package br.com.rifesil.fique.em.casa.tic.tac.toe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rifesil.fique.em.casa.tic.tac.toe.dto.RequestDTO;
import br.com.rifesil.fique.em.casa.tic.tac.toe.dto.ResponseDTO;
import br.com.rifesil.fique.em.casa.tic.tac.toe.service.TicTacToeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/** Controller responsible for handling Jogo operations. */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/jogovelha")
@Api(value = "API TicTacToe game / Jogo da Velha")
public class TicTacToeController {

	/** Service. */
	@Autowired
	private TicTacToeService service;

	@PostMapping
	@ApiOperation(value = "verifica se houve ganhador no Jogo da Velha")
	public ResponseEntity<ResponseDTO> isVelha(@RequestBody @Valid RequestDTO request) {

		ResponseDTO responseDTO = service.hasWon(request);
		log.info("Successfully Jogo with status " + responseDTO.getWon());
		return ResponseEntity.ok().body(responseDTO);
	}

}
