import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MyntraChatbot {

    // Function to convert input to lowercase
    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    // Function to greet the customer with a random welcome message
    public static String greet() {
        String[] greetings = {"Hello! Welcome to Myntra customer service. How can I assist you today?",
                "Hi there! Are you looking for information about a product or need help with your order?"};
        return greetings[new Random().nextInt(greetings.length)];
    }

    // Function to provide a response to the customer's question based on keywords and placeholders
    public static String answer(String question) {
        Map<String, String> responses = new HashMap<>();
        responses.put("delivery times", "Delivery times typically range from {min_days} to {max_days} business days depending on your location and chosen shipping option. You can find more details on the product page.");
        responses.put("return an item", "For hassle-free returns, you can visit our Returns Center at our official website.");
        responses.put("track my order", "Absolutely! You can track your order by signing in to your Myntra account and going to 'Your Orders'.");
        responses.put("specific product", "Sure, tell me more about the product you're interested in. What's the name or do you have a link?");
        responses.put("speak to a representative", "I understand. While I can answer most questions, you can connect with a live representative through our online chat option on the Myntra website.");
        responses.put("order status", "To check your order status, can I get your order number?");
        responses.put("return the item", "For return requests, please visit our Returns & Exchanges page on the Myntra website.");
        responses.put("size chart", "You can refer to our size guide available on the product page to find the perfect fit.");
        responses.put("discount going on", "Hello there! You will find details of discounts and sales on the homepage or while purchasing the product.");
        responses.put("complaint regarding item", "I'm sorry to hear that. Please share your concern, and I'll do my best to assist you.");

        String bestMatch = null;
        int bestMatchScore = 0;
        for (Map.Entry<String, String> entry : responses.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            int score = 0;
            for (String word : key.toLowerCase().split("\\s+")) {
                if (toLowerCase(question).contains(word)) {
                    score++;
                }
            }
            if (score > bestMatchScore) {
                bestMatch = key;
                bestMatchScore = score;
            }
        }

        // Personalize response using placeholders and ask follow-up questions
        String response;
        if (bestMatch != null) {
            response = responses.get(bestMatch);
            if (response.contains("{min_days}")) {
                response = response.replace("{min_days}", "3").replace("{max_days}", "7");  // Replace with actual delivery timeframes
            }
            if (bestMatch.equals("order status")) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Myntra Rep: Please enter your order number: ");
                String orderNumber = scanner.nextLine();
                response += "\n I cannot access specific order details yet, but your order number is " + orderNumber + ". For detailed order information, please visit your Myntra account. Would you like help with anything else?";
            }
        } else {
            response = "I apologize, I couldn't quite understand that. Can you rephrase or ask something different? Perhaps you're looking for information about our popular categories like electronics or clothing?";
        }

        return "Myntra Rep: " + response;
    }

    // Main method to run the main loop of the chatbot interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greet());

        while (true) {
            System.out.print("Customer: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Myntra Rep: Thank you for contacting Myntra! Have a great day.");
                break;
            }
            System.out.println(answer(userInput));
        }
    }
}
