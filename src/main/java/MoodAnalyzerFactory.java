import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {
    public static Constructor<?> getConstructor(Class<?> ... param) throws MoodAnalysisException, ClassNotFoundException, NoSuchMethodException {
        Class<?> moodAnalysisClass = Class.forName("MoodAnalyzer");
        return moodAnalysisClass.getConstructor(param);
    }

    public static Object createMoodAnalyzer(Constructor<?> constructor) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return constructor.newInstance();
    }

}
