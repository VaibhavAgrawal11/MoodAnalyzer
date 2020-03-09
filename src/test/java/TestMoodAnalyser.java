import org.junit.Assert;
import org.junit.Test;
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
}
