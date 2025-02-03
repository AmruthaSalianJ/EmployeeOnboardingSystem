package com.eob.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultApi {

	@GetMapping("/api/public")
	public ResponseEntity<String> publicApi() {
		return ResponseEntity.ok().body("This is a public API");
	}

}
