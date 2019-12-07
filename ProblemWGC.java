import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class ProblemWGC extends Problem {

	boolean goal_test(Object state) {
        StateWGC puzzle_state = (StateWGC) state;

				for(int i = 0; i < puzzle_state.N; i++){
					if (puzzle_state.puzzleArray[i] != 0) {
						return false;
					}
				}
				return true;
	}

    Set<Object> getSuccessors(Object state) {

        Set<Object> set = new HashSet<Object>();
        StateWGC s = (StateWGC) state;
        //int i0 = s.i0, j0 = s.j0;

        StateWGC ss; //successor state

				//1 is starting side, 0 is finish side
				//[farmer(0), wolf(1), goat(2), cabbage(3)]


				//farmer takes himself to finish side
				ss = new StateWGC(s);
				if (ss.puzzleArray[0] == 1) {
					ss.puzzleArray[0] = 0;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//Farmer takes himself to the starting side
				ss = new StateWGC(s);
				if (ss.puzzleArray[0] == 0) {
					ss.puzzleArray[0] = 1;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//Farmer takes the wolf to the finish side
				ss = new StateWGC(s);
				//if the wolf and the farmer are on the same side
				if (ss.puzzleArray[0] == 1 && ss.puzzleArray[1] == 1) {
					ss.puzzleArray[0] = 0;
					ss.puzzleArray[1] = 0;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//Farmer takes the wolf to the starting side
				ss = new StateWGC(s);
				//if the wolf and the farmer are on the same side
				if (ss.puzzleArray[0] == 0 && ss.puzzleArray[1] == 0) {
					ss.puzzleArray[0] = 1;
					ss.puzzleArray[1] = 1;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//Farmer takes the goat to the finish side
				ss = new StateWGC(s);
				//if the farmer and the goat are on the same side
				if (ss.puzzleArray[0] == 1 && ss.puzzleArray[2] == 1) {
					ss.puzzleArray[0] = 0;
					ss.puzzleArray[2] = 0;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//Farmer takes the goat to the starting side
				ss = new StateWGC(s);
				//if the farmer and the goat are on the same side
				if (ss.puzzleArray[0] == 0 && ss.puzzleArray[2] == 0) {
					ss.puzzleArray[0] = 1;
					ss.puzzleArray[2] = 1;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//Farmer takes the cabbage to the finish side
				ss = new StateWGC(s);
				//if the farmer and the cabbage are on the same side
				if (ss.puzzleArray[0] == 1 && ss.puzzleArray[3] == 1) {
					ss.puzzleArray[0] = 0;
					ss.puzzleArray[3] = 0;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

				//Farmer takes the cabbage to the starting side
				ss = new StateWGC(s);
				//if the farmer and the cabbage are on the same side
				if (ss.puzzleArray[0] == 0 && ss.puzzleArray[3] == 0) {
					ss.puzzleArray[0] = 1;
					ss.puzzleArray[3] = 1;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        return set;
    }

	public boolean isValid(StateWGC ss) {
		//if the wolf is left alone with the goat
		if (ss.puzzleArray[1] == ss.puzzleArray[2] && ss.puzzleArray[2] != ss.puzzleArray[0]) {
			return false;
		}
		//if the goat is left alone with the cabbage
		if (ss.puzzleArray[2] == ss.puzzleArray[3] && ss.puzzleArray[2] != ss.puzzleArray[0]) {
			return false;
		}
		return true;
	}

	double step_cost(Object fromState, Object toState) { return 1; }

	public double h(Object state) { return 5; }


	public static void main(String[] args) throws Exception {
		ProblemWGC problem = new ProblemWGC();
		//
		int[] puzzleArray = {1,1,1,1};
		problem.initialState = new StateWGC(puzzleArray);

		Search search  = new Search(problem);

		System.out.println("TreeSearch------------------------");
		System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());
		System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());
		//System.out.println("DepthFirstTreeSearch:\t\t" + search.DepthFirstTreeSearch());
		//System.out.println("GreedyBestFirstTreeSearch:\t" + search.GreedyBestFirstTreeSearch());
		System.out.println("AstarTreeSearch:\t\t" + search.AstarTreeSearch());

		System.out.println("\n\nGraphSearch----------------------");
		System.out.println("BreadthFirstGraphSearch:\t" + search.BreadthFirstGraphSearch());
		System.out.println("UniformCostGraphSearch:\t\t" + search.UniformCostGraphSearch());
		System.out.println("DepthFirstGraphSearch:\t\t" + search.DepthFirstGraphSearch());
		System.out.println("GreedyBestGraphSearch:\t\t" + search.GreedyBestFirstGraphSearch());
		System.out.println("AstarGraphSearch:\t\t" + search.AstarGraphSearch());

		System.out.println("\n\nIterativeDeepening----------------------");
		//System.out.println("IterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
		System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());
	}

}
