import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyser {
    MoodAnalyzer analyzer = new MoodAnalyzer();
    @Test
    public void moodAnalyser_WhenMessageIncludesSad_ShouldReturnSadMood() {
        String result = analyzer.moodAnalyser("I am in Sad Mood");
        Assert.assertEquals("SAD", result);
    }
    @Test
    public void moodAnalyser_WhenMessageNotIncludesSad_ShouldReturnHappy() {
        String result = analyzer.moodAnalyser("I am in Any Mood");
        Assert.assertEquals("HAPPY", result);
    }
}
