package kakaoBank.messageTransfer.dao;

public enum StatusCode {
    SUCCESS("0"),
    ING("1"),
    CANCEL("2");

    private final String value;

    StatusCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
