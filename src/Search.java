import java.util.ArrayList;

public interface Search {

    void search(int[] initial_state,int[] goalState);
    void printPath(Table goalState, ArrayList<Table> exploredStates, int[] initalState);
}
