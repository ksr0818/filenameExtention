package flow.team.domain.file.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class FileDto {
    @Getter
    @Setter
    public static class Post {
        @Size(max= 20)
        private String value;
        private String category;
    }
    @Getter
    @Setter
    public static class Delete {
        private String value;
    }
    @Getter
    @Setter
    public static class Response {
        private Long fileId;
        private String value;
        private String category;
    }

}
