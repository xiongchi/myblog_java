package xiaoxiong.blog.constants;

public enum ResultEnum {
    SUCCESS(0, "返回成功" ),
    ERROR(1, "返回失败")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
