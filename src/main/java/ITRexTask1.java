public class ITRexTask1 {
    public static String str = "I want to be a successful programmer.\n" +
                               "I am ready to use every opportunity to achieve my goal.\n" +
                               "I believe every line of code I've written and every problem I've solved make me closer to my goal.";

    public static void main(String[] args) {
        ChangeText changeText = new ChangeText(str);
        System.out.println(changeText.getSourceText());
    }
}