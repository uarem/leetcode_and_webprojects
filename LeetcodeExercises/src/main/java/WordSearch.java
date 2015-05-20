import java.util.Arrays;

/**
 * Created by uarem on 5/17/2015.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;

        for (int j=0; j<board.length; j++) {
            for (int i=0; i<board[j].length; i++) {
                if (board[j][i] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[j].length];
                    for (int k=0; k<visited.length; k++)
                        Arrays.fill(visited[k], false);
                    visited[j][i] = true;
                    if (visitNeighbors(board, visited, word, 1, j, i))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean visitNeighbors(char[][] board, boolean[][] visited, String word, int index, int y, int x) {
        if (word.length() == index)
            return true;

        if (x>0 && visited[y][x-1]==false && board[y][x-1]==word.charAt(index)) {
            visited[y][x-1] = true;
            if (visitNeighbors(board, visited, word, index+1, y, x-1))
                return true;
            visited[y][x-1] = false;
        }
        if (y>0 && visited[y-1][x]==false && board[y-1][x]==word.charAt(index)) {
            visited[y-1][x] = true;
            if (visitNeighbors(board, visited, word, index+1, y-1, x))
                return true;
            visited[y-1][x] = false;
        }
        if (x+1<visited[y].length && visited[y][x+1]==false && board[y][x+1]==word.charAt(index)) {
            visited[y][x+1] = true;
            if (visitNeighbors(board, visited, word, index+1, y, x+1))
                return true;
            visited[y][x+1] = false;
        }
        if (y+1<visited.length && visited[y+1][x]==false && board[y+1][x]==word.charAt(index)) {
            visited[y+1][x] = true;
            if (visitNeighbors(board, visited, word, index+1, y+1, x))
                return true;
            visited[y+1][x] = false;
        }
        return false;
    }
}
