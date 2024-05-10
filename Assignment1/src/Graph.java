import java.util.*;

class Graph{

    int v;
    List<String> indexToCity;
    Map<String,Integer> cityToIndex;
    LinkedList<Integer>[] adj;

    Graph(int v){
        this.v = v;
        indexToCity = new ArrayList<>();
        cityToIndex = new HashMap<>();
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void DFSUtil(int v, boolean[] visited, int level){
        visited[v] = true;
        System.out.println(indexToCity.get(v) + " level " + level);
        Iterator<Integer> itr = adj[v].listIterator();
        while (itr.hasNext()){
            int n = itr.next();
            if(!visited[n]){
                DFSUtil(n,visited,level+1);
            }
        }
    }

    public void DFS(int source){
        boolean[] visited = new boolean[v];
        DFSUtil(source, visited, 0);
    }

    public void BFS(int source){
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> levels = new LinkedList<>();
        boolean[] visited = new boolean[v];
        queue.offer(source);
        levels.offer(0);
        visited[source] = true;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            int level = levels.poll();

            System.out.println(indexToCity.get(curr) + " level " + level);
            Iterator<Integer> itr = adj[curr].listIterator();
            while (itr.hasNext()){
                int n = itr.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                    levels.offer(level+1);
                }
            }
        }
    }

    public void input(int n){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the names of cities: ");
        for(int i=0;i<n;i++){
            String cityName = sc.next();
            cityToIndex.put(cityName,i);
            indexToCity.add(cityName);
        }
        sc.nextLine();
        System.out.println("Enter (source,destination) else -1");
        while (true){
            String[] input = sc.nextLine().split(" ");

            if(input[0].equals("-1")) break;
            int u = cityToIndex.get(input[0]);
            int v = cityToIndex.get(input[1]);

            adj[u].add(v);
            adj[v].add(u);
        }
    }

    public static void main(String[] args) {

        Graph g = null;
        while (true){
            System.out.println("1. Create");
            System.out.println("2. DFS");
            System.out.println("3. BFS");
            System.out.println("4. Exit");
            System.out.println("Enter choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter no. of ciites: ");
                    int n = sc.nextInt();
                    g = new Graph(n);
                    g.input(n);
                    break;
                case 2:
                    System.out.println("Enter source: ");
                    String source = sc.next();
                    int index = g.cityToIndex.get(source);
                    g.DFS(index);
                    break;
                case 3:
                    System.out.println("Enter source: ");
                    source = sc.next();
                    index = g.cityToIndex.get(source);
                    g.BFS(index);
                case 4:
                    System.exit(0);
            }
        }
    }

}