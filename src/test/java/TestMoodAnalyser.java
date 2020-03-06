import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyser {
    @Test
    public void moodAnalyser_WhenMessageIncludesSad_ShouldReturnSadMood() {
        MoodAnalyzer analyzer = new MoodAnalyzer("I am in Sad Mood");
        String result = analyzer.analyseMood();
        Assert.assertEquals("SAD", result);
    }
    @Test
    public void moodAnalyser_WhenMessageNotIncludesSad_ShouldReturnHappy() {
        MoodAnalyzer analyzer = new MoodAnalyzer(null);
        String result = analyzer.analyseMood();
        Assert.assertEquals("HAPPY", result);
    }
}
