import java.util.Scanner;

public class RunMoodAnalyser {
    public static void main(String[] args) {
        MoodAnalyzer mood=new MoodAnalyzer();
        System.out.println("Enter your mood: ");
        Scanner sc =new Scanner(System.in);
        String yourMood = sc.nextLine();
        System.out.println(mood.moodAnalyser(yourMood));
    }
}
