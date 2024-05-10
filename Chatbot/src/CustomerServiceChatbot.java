import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerServiceChatbot {
    private Map<String, Map<String, String>> context;

    public CustomerServiceChatbot() {
        context = new HashMap<>();
        // Initialize context with default values
        context.put("camera", Map.of("size", "36 MP", "price", "$500"));
        context.put("screen", Map.of("size", "6.5 inches", "price", "$200"));
        context.put("sim", Map.of("size", "Nano-SIM", "price", "$20"));
        context.put("ram", Map.of("size", "8 GB", "price", "$100"));
        context.put("memory", Map.of("size", "128 GB", "price", "$50"));
        context.put("battery", Map.of("size", "4000 mAh", "price", "$80"));
        context.put("current_context", Map.of("context", "None")); // Initialize current context to None
    }

    public void handleUserInput(String userInput) {
        // Check if user input contains a keyword from context
        for (Map.Entry<String, Map<String, String>> entry : context.entrySet()) {
            String keyword = entry.getKey();
            Map<String, String> values = entry.getValue();
            if (userInput.contains(keyword)) {
                // Update current context
                context.put("current_context", values);

                // Provide response based on context
                System.out.print("Chatbot: ");
                if (userInput.equals(keyword)) { // Check if userInput is exactly equal to the keyword
                    System.out.println("Size of " + keyword + " is " + values.get("size") + ".");
                    System.out.println("Price of " + keyword + " is " + values.get("price") + ".");
                } else {
                    if (userInput.contains("size")) {
                        System.out.println("Size of " + keyword + " is " + values.get("size") + ".");
                    }
                    if (userInput.contains("price")) {
                        System.out.println("Price of " + keyword + " is " + values.get("price") + ".");
                    }
                    if (!userInput.contains("size") && !userInput.contains("price")) {
                        System.out.println("I'm sorry, I didn't understand your query. Could you please rephrase?");
                    }
                }
                return;
            }
        }

        // If no context matches, use previously stored context
        if (!context.get("current_context").get("context").equals("None")) {
            System.out.print("Chatbot: ");
            String currentContext = context.get("current_context").get("context");
            Map<String, String> currentValues = context.get(currentContext);
            if (currentValues != null) { // Check if currentValues is not null
                if (userInput.contains("size")) {
                    System.out.println("Size of " + currentContext + " is " + currentValues.get("size") + ".");
                } else if (userInput.contains("price")) {
                    System.out.println("Price of " + currentContext + " is " + currentValues.get("price") + ".");
                } else {
                    System.out.println("I'm sorry, I didn't understand your query. Could you please rephrase?");
                }
            } else {
                System.out.println("I'm sorry, I didn't understand your query. Could you please provide more context?");
            }
        } else {
            System.out.println("Chatbot: I'm sorry, I didn't understand your query. Could you please provide more context?");
        }
    }

    public static void main(String[] args) {
        CustomerServiceChatbot chatbot = new CustomerServiceChatbot();

        System.out.println("Welcome to Customer Service Chatbot");
        System.out.println("You can start chatting. Type 'bye' to exit.");

        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.print("User: ");
            userInput = scanner.nextLine();

            if (userInput.equals("bye")) {
                System.out.println("Chatbot: Goodbye! Have a great day!");
                break;
            }

            chatbot.handleUserInput(userInput);
        }

        scanner.close();
    }
}
