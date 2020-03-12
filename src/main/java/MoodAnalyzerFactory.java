import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {
    public static Constructor<?> getConstructor(String moodAnalyzer, Class<?> ... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalysisClass = Class.forName(moodAnalyzer);
            return moodAnalysisClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(e.getMessage(), MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(e.getMessage(), MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }
    }

    public static Object createMoodAnalyzer(Constructor<?> constructor) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return constructor.newInstance();
    }

}
