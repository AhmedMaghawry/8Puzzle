import java.util.ArrayList;

public interface Search {

    ArrayList<Table> search(int[] initial_state,int[] goalState);
    void printPath(Table goalState, ArrayList<Table> exploredStates, int[] initalState);
}
