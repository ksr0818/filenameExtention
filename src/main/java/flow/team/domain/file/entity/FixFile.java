package flow.team.domain.file.entity;

public enum FixFile {
    FILE1("bat"),
    FILE2("cmd"),
    FILE3("com"),
    FILE4("cpl"),
    FILE5("exe"),
    FILE6("scr"),
    FILE7("js");

    private final String file;

    FixFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public static FixFile getFixFiles(int num) {
        return values()[num];
    }
}
