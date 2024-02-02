package flow.team.domain.file.service;

import flow.team.domain.file.entity.File;
import flow.team.domain.file.repository.FileRepository;
import flow.team.domain.file.dto.FileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository repository;

    public File saveFile(File file) {
        return repository.save(file);
    }

    public List<File> getTextFile() {
        return repository.findAllByCategory("text");
    }


    public boolean existValue(String value) {
        return repository.existsByValue(value);
    }

    public void deleteFile(FileDto.Delete requestBody) {
        File file = repository.findByValue(requestBody.getValue());
        repository.deleteById(file.getFileId());
    }

}
