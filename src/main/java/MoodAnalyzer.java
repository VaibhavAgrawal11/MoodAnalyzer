public class MoodAnalyzer {
    public String moodAnalyser(String message) {
        if(message.contains("Sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}
