public class MoodAnalysisException extends Exception {
    enum ExceptionType
    {
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS, OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE,NO_ACCESS
    }
    ExceptionType type;

    public MoodAnalysisException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public MoodAnalysisException(Throwable cause, ExceptionType type) {
        super(cause);
        this.type = type;
    }

    public MoodAnalysisException(String message, Throwable cause, ExceptionType type) {
        super(message, cause);
        this.type = type;
    }
}
