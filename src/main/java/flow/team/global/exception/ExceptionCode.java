package flow.team.global.exception;

import lombok.Getter;

public enum ExceptionCode {
    LARGE_ENTITY(413,"파일 개수 제한을 초과합니다.");


    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
