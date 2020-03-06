public class MoodAnalyzer {
    private String message;
    public MoodAnalyzer( String message) {
        this.message = message;
    }

    public String analyseMood(String message){
        this.message=message;
        return moodAnalyser();
    }
    public String moodAnalyser() {
        if(message.contains("Sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}
