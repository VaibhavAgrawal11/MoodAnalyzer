import java.util.Objects;

public class MoodAnalyzer {
    String message;

    public  MoodAnalyzer()
    {
    }
    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyseMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyseMood();
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length()==0)
                throw new MoodAnalysisException("You have entered empty mood..!",MoodAnalysisException.ExceptionType.ENTERED_EMPTY);
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException("Please enter valid mood",MoodAnalysisException.ExceptionType.ENTERED_NULL);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
