package br.com.transcendance.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {

	private String type;
	private String token;

}
