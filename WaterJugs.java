import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class WaterJugs extends Problem {

	boolean goal_test(Object state) {
        StateWaterJugs puzzle_state = (StateWaterJugs) state;
        //goal state: if any jug contains exactly 1 gallon
        for(int i = 0; i < puzzle_state.N; i++){
					if (puzzle_state.puzzleArray[i] == 1) {
						return true;
					}
				}
				return false;
	}

    Set<Object> getSuccessors(Object state) {

        Set<Object> set = new HashSet<Object>();
        StateWaterJugs s = (StateWaterJugs) state;
        //int i0 = s.i0, j0 = s.j0;

        StateWaterJugs ss; //successor state

				//fill 12 gallon jug
				ss = new StateWaterJugs(s);
				//if 12 gallon jug is not full
				if (ss.puzzleArray[0] != 12) {
					ss.puzzleArray[0] = 12;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //fill 8 gallon jug
				ss = new StateWaterJugs(s);
				//if 8 gallon jug is not full
				if (ss.puzzleArray[1] != 8) {
					ss.puzzleArray[1] = 8;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //fill 3 gallon jug
				ss = new StateWaterJugs(s);
				//if 3 gallon jug is not full
				if (ss.puzzleArray[2] != 3) {
					ss.puzzleArray[2] = 3;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //empty 12 gallon jug onto the ground
				ss = new StateWaterJugs(s);
				//if 12 gallon jug is not empty
				if (ss.puzzleArray[0] != 0) {
					ss.puzzleArray[0] = 0;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //empty 8 gallon jug onto the ground
				ss = new StateWaterJugs(s);
				//if 8 gallon jug is not empty
				if (ss.puzzleArray[1] != 0) {
					ss.puzzleArray[1] = 0;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //empty 3 gallon jug onto the ground
				ss = new StateWaterJugs(s);
				//if 3 gallon jug is not empty
				if (ss.puzzleArray[2] != 0) {
					ss.puzzleArray[2] = 0;
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //fill 8 gallon jug with 12 gallon jug
				ss = new StateWaterJugs(s);
				//if 8 gallon jug is not full and the 12 gallon jug is not empty
				if (ss.puzzleArray[1] != 8 && ss.puzzleArray[0] != 0) {
          int temp = ss.puzzleArray[0];
					ss.puzzleArray[0] = ss.puzzleArray[0] - (8 - ss.puzzleArray[1]);
          ss.puzzleArray[1] = ss.puzzleArray[1] + (temp - ss.puzzleArray[0]);
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //fill 3 gallon jug with 12 gallon jug
				ss = new StateWaterJugs(s);
				//if 3 gallon jug is not full and the 12 gallon jug is not empty
				if (ss.puzzleArray[2] != 3 && ss.puzzleArray[0] != 0) {
          int temp = ss.puzzleArray[0];
					ss.puzzleArray[0] = ss.puzzleArray[0] - (3 - ss.puzzleArray[2]);
          ss.puzzleArray[2] = ss.puzzleArray[2] + (temp - ss.puzzleArray[0]);
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //fill 12 gallon jug with 8 gallon jug
				ss = new StateWaterJugs(s);
				//if 12 gallon jug is not full and the 8 gallon jug is not empty
				if (ss.puzzleArray[0] != 12 && ss.puzzleArray[1] != 0) {
          int temp = ss.puzzleArray[1];
					ss.puzzleArray[1] = ss.puzzleArray[1] - (12 - ss.puzzleArray[0]);
          ss.puzzleArray[0] = ss.puzzleArray[0] + (temp - ss.puzzleArray[1]);
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //fill 3 gallon jug with 8 gallon jug
				ss = new StateWaterJugs(s);
				//if 3 gallon jug is not full and the 8 gallon jug is not empty
				if (ss.puzzleArray[2] != 3 && ss.puzzleArray[1] != 0) {
          int temp = ss.puzzleArray[1];
					ss.puzzleArray[1] = ss.puzzleArray[1] - (3 - ss.puzzleArray[2]);
          ss.puzzleArray[2] = ss.puzzleArray[2] + (temp - ss.puzzleArray[1]);
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //fill 12 gallon jug with 3 gallon jug
				ss = new StateWaterJugs(s);
				//if 12 gallon jug is not full and the 3 gallon jug is not empty
				if (ss.puzzleArray[0] != 12 && ss.puzzleArray[2] != 0) {
          int temp = ss.puzzleArray[2];
					ss.puzzleArray[2] = ss.puzzleArray[2] - (12 - ss.puzzleArray[0]);
          ss.puzzleArray[0] = ss.puzzleArray[0] + (temp - ss.puzzleArray[2]);
					if (isValid(ss)) {
						set.add(ss);
					}
				}

        //fill 8 gallon jug with 3 gallon jug
				ss = new StateWaterJugs(s);
				//if 8 gallon jug is not full and the 3 gallon jug is not empty
				if (ss.puzzleArray[1] != 8 && ss.puzzleArray[2] != 0) {
          int temp = ss.puzzleArray[2];
					ss.puzzleArray[2] = ss.puzzleArray[2] - (8 - ss.puzzleArray[1]);
          ss.puzzleArray[1] = ss.puzzleArray[1] + (temp - ss.puzzleArray[2]);
					if (isValid(ss)) {
						set.add(ss);
					}
				}


        return set;


    }

	public boolean isValid(StateWaterJugs ss) {
		//12 gallon jug
    if (ss.puzzleArray[0] <= 0 && ss.puzzleArray[0] >= 12) {
      return false;
    }

    //8 gallon jug
    if (ss.puzzleArray[1] <= 0 && ss.puzzleArray[1] >= 8) {
      return false;
    }

    //3 gallon jug
    if (ss.puzzleArray[2] <= 0 && ss.puzzleArray[2] >= 3) {
      return false;
    }
		return true;
	}

	double step_cost(Object fromState, Object toState) { return 1; }

	public double h(Object state) { return 1; }


	public static void main(String[] args) throws Exception {
		WaterJugs problem = new WaterJugs();
		//starting state: all 3 jugs are empty. {(12 Gallon), (8 Gallon), (3 Gallon)}
		int[] puzzleArray = {0,0,0};
		problem.initialState = new StateWaterJugs(puzzleArray);

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
