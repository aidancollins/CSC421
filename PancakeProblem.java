import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class PancakeProblem extends Problem {

	boolean goal_test(Object state) {
        StatePancake puzzle_state = (StatePancake) state;
        int count = 0;
        //goal state: if the pancakes are stacked in decreasing order (0,1,2,...,n-1)
        for (int i = 0; i < puzzle_state.N; i++){
					if (puzzle_state.puzzleArray[i] == i) {
						count++;
					} else {
            return false;
          }
          if (count == puzzle_state.N-1) {
            return true;
          }
				}
				return false;
	}

    Set<Object> getSuccessors(Object state) {
        StatePancake puzzle_state = (StatePancake) state;
        Set<Object> set = new HashSet<Object>();
        StatePancake s = (StatePancake) state;

        int MAX_VALUE = 100;

        StatePancake ss; //successor state

				//Flip N pancakes
        int temp = -1;
        for (int depth = 0; depth < puzzle_state.N; depth++) {
  				ss = new StatePancake(s);
          //flips the stack at depth
					for (int j = 0; j < depth; j++) {
            for(int k = puzzle_state.N -1; k >= 0;k--){
								temp = ss.puzzleArray[j];
							 	ss.puzzleArray[j] = ss.puzzleArray[k];
								ss.puzzleArray[k] = temp;
						}
          }
  				set.add(ss);
       }


        return set;


    }

	double step_cost(Object fromState, Object toState) { return 1; }

	public double h(Object state) { return 0; }


	public static void main(String[] args) throws Exception {
		PancakeProblem problem = new PancakeProblem();
		//starting state
		int[] puzzleArray = {1,0,3,5,2,4};
		problem.initialState = new StatePancake(puzzleArray);

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
		//System.out.println("DepthFirstGraphSearch:\t\t" + search.DepthFirstGraphSearch());
		//System.out.println("GreedyBestGraphSearch:\t\t" + search.GreedyBestFirstGraphSearch());
		System.out.println("AstarGraphSearch:\t\t" + search.AstarGraphSearch());

		System.out.println("\n\nIterativeDeepening----------------------");
		//System.out.println("IterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
		System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());
	}

}
