import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS implements Search {
        Stack<Table> frontier = new Stack<Table>();
        ArrayList<Table> explored = new ArrayList<Table>();

        public ArrayList<Table> search(int[] initial_state, int[] goalState) {

            frontier.add(new Table(initial_state));
            while (!frontier.isEmpty()) {
                Table state = frontier.pop();
                explored.add(state);

                if (state.isEqualPuzzle(new Table(goalState))) {
                    printPath(state,explored,initial_state);
                    return explored;
                }
                for (int i = 0; i < state.getNeighbours().size(); i++) {
                    Table successor = state.getNeighbours().get(i);
                    if (isInExplorer(successor) || isInFrontier(successor)) {
                        continue;
                    } else {
                        successor.setPreState(state);
                        frontier.push(successor);
                    }
                }
            }
            return null;
        }

        private boolean isInFrontier(Table table) {
            for (Table state : frontier) {
                if (table.isEqualPuzzle(state))
                    return true;
            }
            return false;
        }

        private boolean isInExplorer(Table table) {
            for (Table state : explored) {
                if (table.isEqualPuzzle(state))
                    return true;
            }
            return false;
        }

    public void printPath(Table goalState, ArrayList<Table> exploredStates, int[] initalState) {

        Stack<Table> solutionStack = new Stack<Table>();
        solutionStack.push(goalState);
        while (!goalState.isEqualPuzzle(new Table(initalState))) {
            solutionStack.push(goalState.getPreState());
            goalState = goalState.getPreState();
        }
        Table sourceState = new Table(initalState);
        Table destinationState;
        for (int i = solutionStack.size() - 1; i >= 0; i--) {
            destinationState = solutionStack.get(i);
            System.out.println(".............");
            destinationState.display();
            sourceState = destinationState;
        }
    }
}
