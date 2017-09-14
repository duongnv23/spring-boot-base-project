package com.duongnv.spring.web.rest.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/rest/upload")
public class UploadRestController {

	private static final Logger LOGGER = LogManager.getFormatterLogger(UploadRestController.class);

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> upload(@RequestParam("files") MultipartFile[] files) {
		if (files == null || files.length == 0) {
			throw new IllegalArgumentException("File not found");
		}

		LOGGER.info("Uploaded {} file", files.length);
		for (MultipartFile file : files) {
			LOGGER.info("%s -> %s", file.getOriginalFilename(), file.getName());
		}

		return new ResponseEntity(String.format("We receive %s file(s)", files.length), HttpStatus.OK);
	}
}
