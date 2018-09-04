package xiaoxiong.blog.exceptions;

public class DataNotFindException extends RuntimeException {

    public DataNotFindException() {
        super("找不到相关信息");
    }

    public DataNotFindException(String message) {
        super(message);
    }
}
