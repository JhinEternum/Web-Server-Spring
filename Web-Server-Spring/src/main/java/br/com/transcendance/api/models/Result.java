package br.com.transcendance.api.models;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success;

	private String message;

	private Object object;

}
