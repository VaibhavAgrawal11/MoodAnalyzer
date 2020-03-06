import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyser {
    MoodAnalyzer analyzer = new MoodAnalyzer();
    @Test
    public void moodAnalyser_WhenMessageIncludesSad_ShouldReturnSadMood() {
        String result = analyzer.moodAnalyser("I am in Sad Mood");
        Assert.assertEquals("SAD", result);
    }
}
