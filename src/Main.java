import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        int[] ins = {1, 2,5, 3, 4, 0, 6, 7, 8};
        int [] goal = {1,2,3,4,5,6,7,8,0};
        BFS bfs;
        
        System.out.println("Astar");
        AStare a=new AStare();
        a.search(ins,goal);
        bfs = new BFS();
        DFS dfs;
        dfs = new DFS();
        System.out.println("BFS");
        bfs.search(ins,goal);
        System.out.println("..............");

        System.out.println("DFS");

        dfs.search(ins,goal);

//        for (int i=0;i< ans.size();i++){
//            System.out.println("..........");
//            ans.get(i).display();
//
//        }
//        Table table = new Table(ins);
//        int [] parent = {1,2,0,3,4,5,6,7,8};
//        //table.setPreState(new Table(parent));
//
//        Table table1 = new Table(ins);
//        HashSet <Table> ss = new HashSet<Table>();
//        ss.add(table);
//        ss.add(table1);
//        System.out.println(ss.size());
//        table.display();
//
//        ArrayList<Table> neigbours = new ArrayList<Table>();
//         //   System.out.println("hi");
//            neigbours = table.getNeighbours();
//            for(int i=0;i<neigbours.size()
//                    ;i++){
//                System.out.println("................");
//                neigbours.get(i).display();
//            }

//        print(table.move(0,0,Direction.Right));
//        table.display();
//        //table.getPreState().display();
//        print(table.move(1,1,Direction.Right));
//        table.display();
//        table.getPreState().display();
/*
        print(table.move(0,1,Direction.Down));

        table.display();
        table.getPreState().display();
        table.getPreState().getPreState().display();*/

    }
    private static void print(Object o) {
        System.out.println(o);
    }
}
