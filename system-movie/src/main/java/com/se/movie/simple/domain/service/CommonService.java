package com.movieplus.domain.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;

@Component
public class CommonService {
	private final String UPLOAD_DIR = "../local-store/";

	public boolean saveFile(String fileName, InputStream inputStream) throws IOException {
		Path uploadPath = Paths.get(UPLOAD_DIR);
		long fileStore = 0;
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try {
			Path filePath = uploadPath.resolve(fileName.replace(" ", ""));
			fileStore = Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new IOException("Could not save file:  " + fileName, e);
		}
		return fileStore > 0;
	}
}
