import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestMoodAnalyser {
    public MoodAnalyzer analyzer;

    @Test
    public void moodAnalyser_WhenMessageIncludesSad_ShouldReturnSadMood() throws MoodAnalysisException {
        analyzer = new MoodAnalyzer("I am in Sad Mood");
        String result = analyzer.analyseMood();
        Assert.assertEquals("SAD", result);
    }

    @Test
    public void moodAnalyser_WhenMessageNotIncludesSad_ShouldReturnHappy() {
        analyzer = new MoodAnalyzer("I am in Any Mood");
        String result = null;
        try {
            result = analyzer.analyseMood();
        } catch (MoodAnalysisException e) {
        }
        Assert.assertEquals("HAPPY", result);
    }

    @Test
    public void moodAnalyser_WhenMessageNull_ShouldThrowException() throws MoodAnalysisException {
        try {
            analyzer = new MoodAnalyzer(null);
            String result = analyzer.analyseMood();
        }catch( MoodAnalysisException e){
            Assert.assertEquals("Please enter valid mood",e.getMessage());
        }
    }

    @Test
    public void moodAnalyser_WhenMessageIsEmpty_ShouldThrowException() throws MoodAnalysisException {
        try{
            analyzer = new MoodAnalyzer("");
            analyzer.analyseMood();
        }catch ( MoodAnalysisException e){
            Assert.assertEquals("You have entered empty mood..!",e.getMessage());
        }
    }

    @Test
    public void givenHappyMood_WithDefaultConstructor_ShouldReturnHappy() throws NoSuchMethodException, MoodAnalysisException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        analyzer = new MoodAnalyzer();
        Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("MoodAnalyzer");
        Object myObject = MoodAnalyzerFactory.createMoodAnalyzer(constructor);
        boolean equal = analyzer.equals(myObject);
        Assert.assertTrue(equal);
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowMoodAnalysisException() {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("CroodAnalyzer");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenClassConstructor_WhenImproper_ShouldThrowMoodAnalysisException() throws MoodAnalysisException{
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("MoodAnalyzer",Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }
}
