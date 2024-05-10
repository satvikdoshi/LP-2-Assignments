import java.util.*;

//class Graph {
//    int n;
//    List<List<Pair>> graph;
//    Map<String, Integer> cityToIndex;
//    List<String> indexToCity;
//
//    Graph() {
//        n = 0;
//        graph = new ArrayList<>();
//        cityToIndex = new HashMap<>();
//        indexToCity = new ArrayList<>();
//    }
//
//    void createGraph() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter number of cities: ");
//        n = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Enter the city names:");
//        for (int i = 0; i < n; ++i) {
//            String city = scanner.nextLine();
//            cityToIndex.put(city, i);
//            indexToCity.add(city);
//            graph.add(new ArrayList<>());
//        }
//
//        System.out.println("Enter edges (start city, end city, weight), -1 to stop:");
//        while (true) {
//            String[] input = scanner.nextLine().split(" ");
//            if (input[0].equals("-1") || input[1].equals("-1")) {
//                break;
//            }
//
//            int u = cityToIndex.get(input[0]);
//            int v = cityToIndex.get(input[1]);
//            int w = Integer.parseInt(input[2]);
//
//            graph.get(u).add(new Pair(v, w));
//            graph.get(v).add(new Pair(u, w));
//        }
//    }
//
//    void printGraph() {
//        System.out.println("Graph representation:");
//        for (int i = 0; i < n; ++i) {
//            System.out.print(indexToCity.get(i) + " --> ");
//            for (Pair edge : graph.get(i)) {
//                System.out.print("{" + indexToCity.get(edge.first) + ", " + edge.second + "} ");
//            }
//            System.out.println();
//        }
//    }
//
//    void primsAlgo() {
//        int[][] cost = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(cost[i], INF);
//            for (Pair edge : graph.get(i)) {
//                cost[i][edge.first] = edge.second;
//            }
//        }
//
//        int[] visited = new int[n];
//        int[] distance = new int[n];
//        int[] from = new int[n];
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter starting city for Prim's Algorithm: ");
//        String startCity = scanner.nextLine();
//
//        int startVertex = cityToIndex.get(startCity);
//        visited[startVertex] = 1;
//
//        for (int i = 0; i < n; ++i) {
//            distance[i] = cost[startVertex][i];
//            from[i] = startVertex;
//        }
//
//        int ne = n - 1;
//        int minCost = 0;
//
//        while (ne > 0) {
//            int minDist = INF;
//            int v = -1;
//
//            // finding min distance from current vertex
//            for (int i = 0; i < n; ++i) {
//                if (visited[i] == 0 && distance[i] < minDist) {
//                    minDist = distance[i];
//                    v = i;
//                }
//            }
//
//            if (v == -1) {
//                System.err.println("Error: Graph might not be connected.");
//                return;
//            }
//
//            visited[v] = 1;
//            int u = from[v];
//            minCost += cost[u][v];
//
//            System.out.println("Edge " + indexToCity.get(u) + " -> " + indexToCity.get(v) + " with cost " + cost[u][v]);
//
//            for (int i = 0; i < n; ++i) {
//                if (visited[i] == 0 && cost[v][i] < distance[i]) {
//                    distance[i] = cost[v][i];
//                    from[i] = v;
//                }
//            }
//            ne--;
//        }
//
//        System.out.println("Minimum cost of the Minimum Spanning Tree: " + minCost);
//    }
//
//    static class Pair {
//        int first, second;
//
//        Pair(int first, int second) {
//            this.first = first;
//            this.second = second;
//        }
//    }
//
//    static final int INF = 999999;
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Graph g = new Graph();
//        Scanner scanner = new Scanner(System.in);
//        boolean running = true;
//
//        while (running) {
//            System.out.println("\n1. Create Graph with Cities");
//            System.out.println("2. Print Graph");
//            System.out.println("3. Run Prim's Algorithm");
//            System.out.println("4. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    g.createGraph();
//                    break;
//                case 2:
//                    g.printGraph();
//                    break;
//                case 3:
//                    g.primsAlgo();
//                    break;
//                case 4:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//}











class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Graph{

    static final  int INF = 99999;


    static List<String> indexToCity;
    static Map<String,Integer> cityToIndex;
    static List<Pair>[] graph;

    static int v;

    Graph(int v){
        this.v = v;
        indexToCity = new ArrayList<>();
        cityToIndex = new HashMap<>();
        graph = new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }
    }

    public void prims(){
        Scanner sc = new Scanner(System.in);
        int[][] cost = new int[v][v];
        for(int i=0;i<v;i++){
            Arrays.fill(cost[i],INF);
            for(Pair edge : graph[i]){
                cost[i][edge.first] = edge.second;
            }
        }

        int[] visited = new int[v];
        int[] distance = new int[v];
        int[] from = new int[v];

        System.out.println("Enter source: ");
        String cityName = sc.nextLine();
        int startIndex = cityToIndex.get(cityName);
        visited[startIndex] = 1;

        for(int i=0;i<v;i++){
            distance[i] = cost[startIndex][i];
            from[i] = startIndex;
        }

        int ne = v-1;
        int minCost = 0;

        while(ne > 0){
            int minDist = INF;
            int v1 = -1;

            for(int i=0;i<v;i++){
                if(visited[i] == 0 && distance[i] < minDist){
                    minDist = distance[i];
                    v1 = i;
                }
            }
            if(v1 == -1){
                System.out.println("eror");
                return;
            }
            visited[v1] = 1;
            int u = from[v1];
            minCost += cost[u][v1];

            System.out.println(indexToCity.get(u) + " to " + indexToCity.get(v1) + " with " + cost[u][v1]);
            for(int i=0;i<v;i++){
                if(visited[i] == 0 && cost[v1][i] < distance[i]){
                    distance[i] = cost[v1][i];
                    from[i] = v1;
                }
            }
            ne--;
        }
        System.out.println(minCost);
    }

    public static void input(int v){

        System.out.println("Enter the city Names: ");
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<v;i++){
            String cityName = sc.next();
            cityToIndex.put(cityName,i);
            indexToCity.add(cityName);
        }
        sc.nextLine();
        System.out.println("Enter the (source,destination,weight) else -1");
        while (true){
            String[] input = sc.nextLine().split(" ");
            if(input[0].equalsIgnoreCase("-1")) break;

            int u = cityToIndex.get(input[0]);
            int v1 = cityToIndex.get(input[1]);
            int w = Integer.parseInt(input[2]);

            graph[u].add(new Pair(v1,w));
            graph[v1].add(new Pair(u,w));
        }
    }

    void printGraph(){
        for(int i=0;i<v;i++){
            System.out.println(indexToCity.get(i) + "-->");
            for(Pair edge : graph[i]){
                System.out.print("{" + indexToCity.get(edge.first) + ", " + edge.second + "} ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = null;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. crate");
            System.out.println("2. Prims");
            System.out.println("3. Exit");
            System.out.println("4. print");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter no. of cities: ");
                    int n = sc.nextInt();
                    g = new Graph(n);
                    g.input(n);
                    break;

                case 2:
                    g.prims();
                    break;
                case 3:
                    System.exit(0);
                case 4:
                    g.printGraph();
            }
        }
    }
}