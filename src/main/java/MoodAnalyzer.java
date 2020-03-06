public class MoodAnalyzer {
    public String moodAnalyser(String message) {
        if(message.contains("sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}
