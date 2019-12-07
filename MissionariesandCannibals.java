import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class MissionariesandCannibals extends Problem {

	boolean goal_test(Object state) {
        StateMC puzzle_state = (StateMC) state;

				if (puzzle_state.puzzleArray[0] == 0 &&
				puzzle_state.puzzleArray[1] == 0 &&
				puzzle_state.puzzleArray[2] == 1 &&
				puzzle_state.puzzleArray[3] == 3 &&
				puzzle_state.puzzleArray[4] == 3) {
					return true;
				}
				return false;
	}

    Set<Object> getSuccessors(Object state) {

        Set<Object> set = new HashSet<Object>();
        StateMC s = (StateMC) state;
        //int i0 = s.i0, j0 = s.j0;

        StateMC ss; //successor state

				//0 is left side, 1 is right side
				//[(# of missionaries on the left), (# of cannibals on the left), (boat), (# of missionaries on the right), (# of cannibals on the right)]


				//cannibal takes the boat from left to right
				ss = new StateMC(s);
				//if the boat is on the left with a cannibal
				if (ss.puzzleArray[2] == 0 && ss.puzzleArray[1] > 0) {
					ss.puzzleArray[2] = 1;
					ss.puzzleArray[1] -= 1;
					ss.puzzleArray[4] += 1;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//cannibal takes the boat from right to left
				ss = new StateMC(s);
				//if the boat is on the right with a cannibal
				if (ss.puzzleArray[2] == 1 && ss.puzzleArray[4] > 0) {
					ss.puzzleArray[2] = 0;
					ss.puzzleArray[1] += 1;
					ss.puzzleArray[4] -= 1;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//missionary takes the boat from left to right
				ss = new StateMC(s);
				//if the boat is on the left with a missionary
				if (ss.puzzleArray[2] == 0 && ss.puzzleArray[0] > 0) {
					ss.puzzleArray[2] = 1;
					ss.puzzleArray[0] -= 1;
					ss.puzzleArray[3] += 1;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//missionary takes the boat from right to left
				ss = new StateMC(s);
				//if the boat is on the right with a missionary
				if (ss.puzzleArray[2] == 1 && ss.puzzleArray[3] > 0) {
					ss.puzzleArray[2] = 0;
					ss.puzzleArray[0] += 1;
					ss.puzzleArray[3] -= 1;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//2 cannibals takes the boat from left to right
				ss = new StateMC(s);
				//if the boat is on the left with 2 cannibals
				if (ss.puzzleArray[2] == 0 && ss.puzzleArray[1] >= 2) {
					ss.puzzleArray[2] = 1;
					ss.puzzleArray[1] -= 2;
					ss.puzzleArray[4] += 2;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//2 cannibals takes the boat from right to left
				ss = new StateMC(s);
				//if the boat is on the right with 2 cannibals
				if (ss.puzzleArray[2] == 1 && ss.puzzleArray[4] >= 2) {
					ss.puzzleArray[2] = 0;
					ss.puzzleArray[1] += 2;
					ss.puzzleArray[4] -= 2;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//2 missionaries takes the boat from left to right
				ss = new StateMC(s);
				//if the boat is on the left with 2 missionaries
				if (ss.puzzleArray[2] == 0 && ss.puzzleArray[0] >= 2) {
					ss.puzzleArray[2] = 1;
					ss.puzzleArray[0] -= 2;
					ss.puzzleArray[3] += 2;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//2 missionaries takes the boat from right to left
				ss = new StateMC(s);
				//if the boat is on the right with 2 missionaries
				if (ss.puzzleArray[2] == 1 && ss.puzzleArray[3] >= 2) {
					ss.puzzleArray[2] = 0;
					ss.puzzleArray[0] += 2;
					ss.puzzleArray[3] -= 2;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//1 missionary and 1 cannibal takes the boat from left to right
				ss = new StateMC(s);
				//if the boat is on the left with 1 missionary and 1 cannibal
				if (ss.puzzleArray[2] == 0 && ss.puzzleArray[0] > 0 && ss.puzzleArray[1] > 0) {
					ss.puzzleArray[2] = 1;
					ss.puzzleArray[0] -= 1;
					ss.puzzleArray[3] += 1;
					ss.puzzleArray[1] -= 1;
					ss.puzzleArray[4] += 1;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//1 missionary and 1 cannibal takes the boat from right to left
				ss = new StateMC(s);
				//if the boat is on the right with 1 missionary and 1 cannibal
				if (ss.puzzleArray[2] == 1 && ss.puzzleArray[3] > 0 && ss.puzzleArray[4] > 0) {
					ss.puzzleArray[2] = 0;
					ss.puzzleArray[0] += 1;
					ss.puzzleArray[3] -= 1;
					ss.puzzleArray[1] += 1;
					ss.puzzleArray[4] -= 1;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        return set;


    }

	public boolean isValid(StateMC ss) {
		//if there are more cannibals than missionaries on the left
		if (ss.puzzleArray[0] < ss.puzzleArray[1]) {
			return false;
		}
		//if there are more cannibals than missionaries on the right
		if (ss.puzzleArray[3] < ss.puzzleArray[4]) {
			return false;
		}
		return true;
	}

	double step_cost(Object fromState, Object toState) { return 1; }

	public double h(Object state) { return 11; }


	public static void main(String[] args) throws Exception {
		MissionariesandCannibals problem = new MissionariesandCannibals();
		//
		int[] puzzleArray = {3,3,0,0,0};
		problem.initialState = new StateMC(puzzleArray);

		Search search  = new Search(problem);

		System.out.println("TreeSearch------------------------");
		//System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());
		//System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());
		//System.out.println("DepthFirstTreeSearch:\t\t" + search.DepthFirstTreeSearch());
		//System.out.println("GreedyBestFirstTreeSearch:\t" + search.GreedyBestFirstTreeSearch());
		//System.out.println("AstarTreeSearch:\t\t" + search.AstarTreeSearch());

		System.out.println("\n\nGraphSearch----------------------");
		System.out.println("BreadthFirstGraphSearch:\t" + search.BreadthFirstGraphSearch());
		//System.out.println("UniformCostGraphSearch:\t\t" + search.UniformCostGraphSearch());
		//System.out.println("DepthFirstGraphSearch:\t\t" + search.DepthFirstGraphSearch());
		//System.out.println("GreedyBestGraphSearch:\t\t" + search.GreedyBestFirstGraphSearch());
		//System.out.println("AstarGraphSearch:\t\t" + search.AstarGraphSearch());

		System.out.println("\n\nIterativeDeepening----------------------");
		System.out.println("IterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
		System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());
	}

}
