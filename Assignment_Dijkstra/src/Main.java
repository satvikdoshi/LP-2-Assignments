import java.util.*;

class Edge{
    int neighbor;
    int wt;

    Edge(int neighbor, int wt){
        this.neighbor = neighbor;
        this.wt = wt;
    }
}

class Pair implements Comparable<Pair>{
    int v;
    String psf;
    int wsf;

    Pair(int v, String psf, int wsf){
        this.v = v;
        this.psf = psf;
        this.wsf = wsf;
    }

    public int compareTo(Pair o){
        return this.wsf - o.wsf;
    }
}
class Graph{

    int n;
    List<String> indexToCity;
    Map<String,Integer> cityToIndex;
    List<Edge>[] graph;

    Graph(int n){
        this.n = n;
        indexToCity = new ArrayList<>();
        cityToIndex = new HashMap<>();
        graph = new ArrayList[n];
        for (int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
    }

    public void input(int n){
        System.out.println("Enter city names: ");
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++){
            String cityName = sc.next();
            indexToCity.add(cityName);
            cityToIndex.put(cityName,i);
        }
        sc.nextLine();
        System.out.println("Enter (source,destination,weight) else -1: ");
        while(true){
            String[] input = sc.nextLine().split(" ");
            if(input[0].equalsIgnoreCase("-1")) break;
            int u = cityToIndex.get(input[0]);
            int v = cityToIndex.get(input[1]);
            int w = Integer.parseInt(input[2]);

            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }
    }

    public void dijkstra(String srcCity, String destCity){

        int srcIndex = cityToIndex.get(srcCity);
        int destIndex = cityToIndex.get(destCity);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(srcIndex, indexToCity.get(srcIndex) + "-->",0));
        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(visited[curr.v]) continue;;

            if(curr.v == destIndex){
                System.out.println("Shortest Path from: " + indexToCity.get(srcIndex) + " to " + indexToCity.get(destIndex) + ": " + curr.psf + " with cost: " + curr.wsf);
                return;
            }
            for(Edge edge : graph[curr.v]){
                if(!visited[edge.neighbor]){
                    pq.add(new Pair(edge.neighbor, curr.psf + indexToCity.get(edge.neighbor) + "-->", curr.wsf + edge.wt));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of cities: ");
        int n = sc.nextInt();

        Graph g = new Graph(n);

        while(true){
            System.out.println("1. Create ");
            System.out.println("2. Dijkstras");
            System.out.println("3. Exit");
            System.out.println("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    g.input(n);
                    break;
                case 2:
                    System.out.println("Enter source city: ");
                    String src = sc.next();
                    System.out.println("Enter destination city: ");
                    String dest = sc.next();

                    g.dijkstra(src, dest);
                    break;
            }
        }
    }
}