public class Main {

    public static void main(String[] args) {
        int[] ins = {1, 2, 5, 3, 4, 0, 6, 7, 8};
        Table table = new Table(ins);
        table.display();
        print(table.move(0,0,Direction.Right));
        table.display();
        //table.getPreState().display();
        print(table.move(1,1,Direction.Right));
        table.display();
        table.getPreState().display();

        print(table.move(0,1,Direction.Down));

        table.display();
        table.getPreState().display();
        table.getPreState().getPreState().display();

    }
    private static void print(Object o) {
        System.out.println(o);
    }
}
