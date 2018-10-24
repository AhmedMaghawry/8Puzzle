public class Table {

    private Table preState;
    private int table_size = 3;
    private int[][] content;

    public Table(int[] initial_state) {
        content = from_1d_to_2d(initial_state);
        preState = null;
    }

    private int[][] from_1d_to_2d(int [] list) {
         int[][] res = new int[table_size][table_size];
        for (int i  = 0; i < table_size; i++) {
            for (int j = 0; j < table_size; j++) {
                res[i][j] = list[i * table_size + j];
            }
        }
        return res;
    }

    private int[] from_2d_to_1d(int [][] list) {
        int[] res = new int[table_size * table_size];
        for (int i  = 0; i < table_size; i++) {
            for (int j = 0; j < table_size; j++) {
                res[i * table_size + j] = list[i][j];
            }
        }
        return res;
    }

    public boolean move(int row, int col, Direction direction) {

        if (row < 0 || row >= table_size || col < 0 || col >= table_size)
            return false;

        switch (direction) {
            case Left:
                if (col == 0 || content[row][col - 1] != 0)
                    return false;
                else
                    swap(row, col, row, col - 1);
                break;
            case Right:
                if (col == (table_size - 1) || content[row][col + 1] != 0)
                    return false;
                else
                    swap(row, col, row, col + 1);
                break;
            case Top:
                if (row == 0 || content[row - 1][col] != 0)
                    return false;
                else
                    swap(row, col, row - 1, col);
                break;
            case Down:
                if (row == (table_size - 1) || content[row + 1][col] != 0)
                    return false;
                else
                    swap(row, col, row + 1, col);
                break;
        }
        return true;
    }

    private void swap(int row, int col, int row1, int col1) {
        try {
            preState = (Table) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        int temp = content[row][col];
        content[row][col] = content[row1][col1];
        content[row1][col1] = temp;
    }

    public void display() {
        for (int i = 0; i < table_size; i++) {
            for (int j = 0; j < table_size; j++) {
                System.out.print(content[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    public Table getPreState() {
        return preState;
    }

    public void setPreState(Table preState) {
        this.preState = preState;
    }

    public int[][] getContent() {
        return content;
    }

    public void setContent(int[][] content) {
        this.content = content;
    }

    @Override
    protected Table clone() throws CloneNotSupportedException {
        int [] l = from_2d_to_1d(content);
        Table copy = new Table(l);
        copy.setPreState(this.preState);
        return copy;
    }
}
