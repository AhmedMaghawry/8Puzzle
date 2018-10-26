import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.lang.model.element.NestingKind;

public class AStare implements Search {

	Comparator<Table> tableComparator = new Comparator<Table>() {
		@Override
		public int compare(Table t1, Table t2) {
			return (heurestic(t1.getContent())+t1.cost) - (heurestic(t2.getContent())+t2.cost);
		}
	};

	int heurestic(int[][] t) {
		int sum = 0;
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				int nu = t[i][j];
				if (nu == 0)
					nu = 9;
				sum += Math.abs(((nu - 1) / 3) - i);
				sum += Math.abs(((nu - 1) % 3) - j);
			}
		}
		return sum;

	}

	PriorityQueue<Table> frontier = new PriorityQueue<Table>(tableComparator);
	ArrayList<Table> explored = new ArrayList<Table>();

	public void  search(int[] initial_state, int[] goalState) {

		frontier.add(new Table(initial_state));

		while (!frontier.isEmpty()) {
			Table state = frontier.poll();
//			System.out.println(state.cost+(heurestic(state.getContent())));
			explored.add(state);

			if (state.isEqualPuzzle(new Table(goalState))) {
				printPath(state, explored, initial_state);
				return;
			}
			if (explored.size()>20000){
				System.out.println("Early Stop,Explored nodes exceeded 20000 ");
				return;
			}
			ArrayList<Table> neigbours = state.getNeighbours();
			for (int i = 0; i < neigbours.size(); i++) {
				Table successor = neigbours.get(i);
				if (!(isInExplorer(successor) || isInFrontier(successor))) {
					successor.setPreState(state);
					frontier.add(successor);
				} else if (isInFrontier(successor)) {
					updateFrontier(successor);
				}
			}
		}
	}

	private boolean updateFrontier(Table table) {
		for (Table state : frontier) {
			if (table.isEqualPuzzle(state)) {
				if(table.cost<state.cost){
					frontier.remove(state);
					frontier.add(table);
				}
				return true;
			}
		}
		return false;
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
