public class StateMC
{
	int N;
  int[] puzzleArray;

    public StateMC(int[] puzzleArray) {
    	this.puzzleArray = puzzleArray;
    	N = puzzleArray.length;
    }

    //It has to be a copy of values not reference because we will
    //create many states and don't want to overwrite the same array.
    public StateMC(StateMC state) {
    	N = state.N;
    	puzzleArray = new int[N];

        for(int i=0; i<N; i++)
        	puzzleArray[i] = state.puzzleArray[i];

    }

		public String toString() {
      String str = "";
      for (int i = 0; i < N; i++){
    	   str = str + " " + this.puzzleArray[i];
      }
      return str;
    }

}
