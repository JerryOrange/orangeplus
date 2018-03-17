package ncu.jerry.orangeplus.common.base;

/**
 * custom runtime Exception
 *
 * Created by Jiacheng on 2018/2/6.
 */
public class CustomRuntimeException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private int code;

    public CustomRuntimeException() {
        super();
    }

    public CustomRuntimeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CustomRuntimeException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
