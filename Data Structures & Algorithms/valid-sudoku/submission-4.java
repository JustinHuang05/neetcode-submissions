class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, HashSet<Character>> map = new HashMap<String, HashSet<Character>>();

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowSet = new HashSet<Character>();
            HashSet<Character> colSet = new HashSet<Character>();
            for (int x = 0; x < board.length; x++) {
                if (board[i][x] != '.') {
                    if (rowSet.contains(board[i][x])) {
                        System.out.println("1");
                        return false;
                    }
                    rowSet.add(board[i][x]);

                    String key = String.valueOf(i / 3) + String.valueOf(x / 3);
                    if (map.containsKey(key)) {
                        if (map.get(key).contains(board[i][x])) {
                            System.out.println("2");
                            return false;
                        }
                        HashSet<Character> set = map.get(key);
                        set.add(board[i][x]);
                        map.put(key, set);
                    } else {
                        HashSet<Character> set = new HashSet<Character>();
                        set.add(board[i][x]);
                        map.put(key, set);
                    }
                }

                if (board[x][i] != '.') {
                    if (colSet.contains(board[x][i])) {
                        System.out.println("3");
                        return false;
                    }
                    colSet.add(board[x][i]);
                }
            }
        }

        return true;
    }
}
