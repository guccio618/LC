
public class Q041_First_Missing_Positive {
	//by ninechapter using counting sort
	public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
                int tmp = A[A[i]-1];       //3,4,-1,1
                if (tmp == A[i]) {
                    break;
                }
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }

        for (int i = 0; i < A.length; i ++) {
                if (A[i] != i + 1) {
                    return i + 1;
                }
        }

        return A.length + 1;
    }
	
	public static void main(String[] args){
		Q041_First_Missing_Positive test = new Q041_First_Missing_Positive();
		int[] array = {3,4,-1,1};
		System.out.println(test.firstMissingPositive(array));
	} 
}
