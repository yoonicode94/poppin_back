package dev.zeronelab.mybatis.controller;

import dev.zeronelab.mybatis.dto.UploadResultDTO;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UploadController {

	@Value("${dev.popup.upload.path}")
	private String uploadPath;

	// 파일 업로드
	@PostMapping("/uploadAjax")
	public ResponseEntity<List<String>> uploadFile(@RequestParam("files") MultipartFile[] uploadFiles) {
		List<String> savedFilePaths = new ArrayList<>();

		for (MultipartFile uploadFile : uploadFiles) {
			if (!uploadFile.getContentType().startsWith("image/")) {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}

			String originalName = uploadFile.getOriginalFilename();
			String folderPath = makeFolder();

			String uuid = UUID.randomUUID().toString();
			String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + originalName;
			Path savePath = Paths.get(saveName);

			try {
				// 파일 저장
				uploadFile.transferTo(savePath);
				savedFilePaths.add(saveName); // 저장된 파일 경로 추가
			} catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<>(savedFilePaths, HttpStatus.OK);
	}

	// 날짜별 폴더 생성
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		String folderPath = str.replace("/", File.separator);

		// 폴더 생성
		File uploadPathFolder = new File(uploadPath, folderPath);
		if (!uploadPathFolder.exists()) {
			uploadPathFolder.mkdirs();
		}
		return folderPath;
	}
}