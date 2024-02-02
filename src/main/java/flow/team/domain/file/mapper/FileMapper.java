package flow.team.domain.file.mapper;

import flow.team.domain.file.dto.FileDto;
import flow.team.domain.file.entity.File;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileMapper {
    default File filePostDtoToFile(FileDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        File.FileBuilder file = File.builder();

        file.value( requestBody.getValue() );
        file.category(requestBody.getCategory());

        return file.build();
    }
    default FileDto.Response fileToFileResponseDto(File file) {
        if ( file == null ) {
            return null;
        }

        FileDto.Response response = new FileDto.Response();

        response.setFileId(file.getFileId());
        response.setValue(file.getValue());
        response.setCategory(file.getCategory());

        return response;
    }

    List<FileDto.Response> filesToFileResponseDtos(List<File> files);
}
