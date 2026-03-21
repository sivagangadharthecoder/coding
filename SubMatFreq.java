import java.util.*;

public class SubMatFreq {

    public static int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] sum = new int[m][n];
        int[][] xCount = new int[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int val = 0;
                if (grid[i][j] == 'X')
                    val = 1;
                else if (grid[i][j] == 'Y')
                    val = -1;

                int x = (grid[i][j] == 'X') ? 1 : 0;

                sum[i][j] = val;
                xCount[i][j] = x;

                if (i > 0) {
                    sum[i][j] += sum[i - 1][j];
                    xCount[i][j] += xCount[i - 1][j];
                }

                if (j > 0) {
                    sum[i][j] += sum[i][j - 1];
                    xCount[i][j] += xCount[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    sum[i][j] -= sum[i - 1][j - 1];
                    xCount[i][j] -= xCount[i - 1][j - 1];
                }

                if (sum[i][j] == 0 && xCount[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = Character.toUpperCase(sc.next().charAt(0));
            }
        }

        System.out.println(numberOfSubmatrices(grid));

        sc.close();
    }
}