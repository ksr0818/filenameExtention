package flow.team.domain.file.controller;

import flow.team.domain.file.entity.File;
import flow.team.domain.file.dto.FileDto;
import flow.team.domain.file.entity.FixFile;
import flow.team.domain.file.mapper.FileMapper;
import flow.team.domain.file.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
@Slf4j
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileController {

    private final FileService service;
    private final FileMapper mapper;
    @PostMapping
    public ResponseEntity PostFile(@Validated @RequestBody FileDto.Post requestBody) {
        File file = mapper.filePostDtoToFile(requestBody);

        // 커스텀확장자 200 이상인 경우 에러 발생
        List<File> textFiles= service.getTextFile();
        if (textFiles.size() >= 10) {
            String errorMessage = "파일 개수 제한을 초과합니다.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

        // 이미 데이터가 존재하는 경우 에러 처리
        if (service.existValue(requestBody.getValue())){
            String errorMessage = "확장자명 중복!";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
        }

        // 커스텀확장자에 고정 확장자가 포함 된 경우 에러 발생
//        for (int i =0; i < 7; i++) {
//            if (requestBody.getValue().equals(FixFile.getFixFiles(i).getFile())) {
//                String errorMessage = "고정 확장자에 이미 존재합니다.";
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
//            }
//        }

        File savedFile = service.saveFile(file);
        return new ResponseEntity((mapper.fileToFileResponseDto(savedFile)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getTextFile() {
        List<File> files =service.getTextFile();
        return new ResponseEntity(mapper.filesToFileResponseDtos(files), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteFile(@RequestBody FileDto.Delete requestBody) {
        service.deleteFile(requestBody);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
