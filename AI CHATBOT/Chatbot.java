import java.util.Scanner;

public class Chatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("===== AI CHATBOT =====");

        while (true) {
            System.out.print("\nYou: ");
            String userInput = sc.nextLine().toLowerCase();

            // Exit condition
            if (userInput.equals("exit") || userInput.equals("bye")) {
                System.out.println("Bot: Bye! Have a great day 😊");
                break;
            }

            // Rule-based replies
            if (userInput.contains("hello") || userInput.contains("hi")) {
                System.out.println("Bot: Hello! How can I help you today?");
            }
            else if (userInput.contains("how are you")) {
                System.out.println("Bot: I'm doing great! Thanks for asking 😊");
            }
            else if (userInput.contains("your name")) {
                System.out.println("Bot: I am Java Chatbot created by Priyanshi!");
            }
            else if (userInput.contains("college")) {
                System.out.println("Bot: You study in SAGE University, Indore, right?");
            }
            else if (userInput.contains("java")) {
                System.out.println("Bot: Java is an Object-Oriented language. Very powerful!");
            }
            else if (userInput.contains("help")) {
                System.out.println("Bot: You can ask me anything about Java, studies, or general info!");
            }
            else {
                // default reply
                System.out.println("Bot: Sorry, I didn’t understand that. Can you rephrase?");
            }
        }

        sc.close();
    }
}