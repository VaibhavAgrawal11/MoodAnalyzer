import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {
    public static Constructor<?> getConstructor(String moodAnalyzer, Class<?> ... param) throws MoodAnalysisException {
        try {
            if (moodAnalyzer == null)
                moodAnalyzer="MoodAnalyzer";
            Class<?> moodAnalysisClass = Class.forName(moodAnalyzer);
            return moodAnalysisClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(e.getMessage(), MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(e.getMessage(), MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }
    }

    public static Object createMoodAnalyzer(Constructor<?> constructor, Object ... message) throws MoodAnalysisException {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException e) {
            throw new MoodAnalysisException(e,MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(e,MoodAnalysisException.ExceptionType.NO_ACCESS);
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(e,MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE);
        }
    }

    public static Object invokeMethod(Object moodObject, String analyseMood) throws MoodAnalysisException {
        try {
            Method callMethod = moodObject.getClass().getMethod(analyseMood);
            Object result = callMethod.invoke(moodObject);
            return result;
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(e,MoodAnalysisException.ExceptionType.NO_ACCESS);
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(e,MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(e,MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }
    }

    public static void setFieldValue(Object moodObject, String fieldName, String fieldValue) {
        try {
            Class<?> className = moodObject.getClass();
            Field field = className.getDeclaredField(fieldName);
            field.set(moodObject,fieldValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
