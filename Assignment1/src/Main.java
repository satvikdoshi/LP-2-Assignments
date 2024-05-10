import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Graph graph = null; // Declare Graph object outside the loop

        while (true) {

            System.out.println("1. Create Graph");
            System.out.println("2. DFS");
            System.out.println("3. BFS");
            System.out.println("4. Exit");

            System.out.println("Enter Your Choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    graph = new Graph(0); // Reset graph object
                    Graph.input(); // Pass the graph object to the input method
                    break;
                case 2:
                    if (graph != null) {
                        System.out.println("DFS Traversal:");
                        System.out.println("Enter the source city: ");
                        String source = sc.next();
                        int index = graph.findCityIndex(source);
                        if (index != -1)
                            graph.DFS(index);
                        else
                            System.out.println("City not found.");
                        System.out.println();
                    } else {
                        System.out.println("Graph is not created yet.");
                    }
                    break;
                case 3:
                    if (graph != null) {
                        System.out.println("BFS Traversal:");
                        System.out.println("Enter the source city: ");
                        String source = sc.next();
                        int index = graph.findCityIndex(source);
                        if (index != -1)
                            graph.BFS(index);
                        else
                            System.out.println("City not found.");
                        System.out.println();
                    } else {
                        System.out.println("Graph is not created yet.");
                    }
                    break;
                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);
                default:
                    System.out.println("Choose from above options....");
            }
        }
    }
}
