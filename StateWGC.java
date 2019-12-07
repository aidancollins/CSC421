public class StateWGC
{
	int N;
  int[] puzzleArray;

    public StateWGC(int[] puzzleArray) {
    	this.puzzleArray = puzzleArray;
    	N = puzzleArray.length;
    }

    //It has to be a copy of values not reference because we will
    //create many states and don't want to overwrite the same array.
    public StateWGC(StateWGC state) {
    	N = state.N;
    	puzzleArray = new int[N];

        for(int i=0; i<N; i++)
        	puzzleArray[i] = state.puzzleArray[i];

    }

		public boolean equals(Object o) {
				StateWGC state = (StateWGC) o;
				for (int i = 0; i < N; i++) {
					if (this.puzzleArray[i] != state.puzzleArray[i]) {
						return false;
					}
				}
				return true;
		}

		public int hashCode() {
				int result = 0;
				for (int i = 0; i < N; i++) {
					result += this.puzzleArray[i] * Math.pow(10, i);
				}
				return result;
		}

		public String toString() {
      String str = "";
      for (int i = 0; i < N; i++){
    	   str = str + " " + this.puzzleArray[i];
      }
      return str;
    }

}
