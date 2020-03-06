import java.util.Scanner;

public class RunMoodAnalyser {
    public static void main(String[] args) {
        System.out.println("Enter your mood: ");
        Scanner sc =new Scanner(System.in);
        String yourMood = sc.nextLine();
        MoodAnalyzer mood=new MoodAnalyzer(yourMood);
        System.out.println(mood.moodAnalyser());
    }
}
