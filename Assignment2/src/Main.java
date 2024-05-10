import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Game {
    int row, col;
    Scanner sc = new Scanner(System.in);
    ArrayList<ArrayList<Integer>> playground;

    public Game(int n, int m) {
        row = n;
        col = m;
        playground = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                rowList.add(1);
            }
            playground.add(rowList);
        }
    }

    void addObstacle(int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col) {
            System.out.println("Sorry, out of grid. Enter valid coordinates.");
        } else {
            playground.get(r).set(c, 0);
        }
    }

    void designPlayground() {
        System.out.println("There are " + row + " rows.");
        System.out.println("There are " + col + " columns.");

        boolean f = true;

        while (f) {
            int r, c;
            System.out.println("Enter row no and col no of obstacle: ");
            r = sc.nextInt();
            c = sc.nextInt();
            addObstacle(r, c);

            System.out.println("Enter 1 to add obstacles, else enter 0: ");
            int flag = sc.nextInt();

            f = flag == 1;
        }

        showPlayground();
    }

    void showPlayground() {
        System.out.println("Designed playground: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(playground.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    boolean isReachable(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    int AStarAlgorithm(int startX, int startY, int goalX, int goalY) {
        int[][] currentDistance = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                currentDistance[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] dirs = {0, 1, 0, -1, 0};

        currentDistance[startX][startY] = 0;
        pq.offer(new int[]{0, startX, startY});

        while (!pq.isEmpty()) {
            int[] it = pq.poll();
            int distance = it[0];
            int currX = it[1];
            int currY = it[2];

            if (currX == goalX && currY == goalY) {
                return currentDistance[currX][currY];
            }

            for (int i = 0; i < 4; i++) {
                int newX = currX + dirs[i];
                int newY = currY + dirs[i + 1];

                if (isReachable(newX, newY) && playground.get(newX).get(newY) == 1) {
                    if (distance + 1 < currentDistance[newX][newY]) {
                        currentDistance[newX][newY] = distance + 1;
                    }

                    if (newX == goalX && newY == goalY) {
                        return currentDistance[newX][newY];
                    }

                    pq.offer(new int[]{distance + 1, newX, newY});
                }
            }
        }

        return -1;
    }

    void play() {
        designPlayground();

        int startX, startY, goalX, goalY;

        System.out.println("Enter starting x point and starting y point: ");
        startX = sc.nextInt();
        startY = sc.nextInt();

        System.out.println("Enter ending x point and ending y point: ");
        goalX = sc.nextInt();
        goalY = sc.nextInt();

        int distance = AStarAlgorithm(startX, startY, goalX, goalY);

        if (distance == -1) {
            System.out.println("Goal is not reachable.");
        } else {
            System.out.println("Goal is reachable with distance: " + distance);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        playAGame();
    }

    static void playAGame() {
        int r, c;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rows in playground: ");
        r = sc.nextInt();

        System.out.println("Enter columns in playground: ");
        c = sc.nextInt();

        Game game = new Game(r, c);
        game.play();
    }
}
