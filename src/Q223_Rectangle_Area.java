
public class Q223_Rectangle_Area {
	// by Jackie
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int leftSide_A = Math.min(A, C);
        int rightSide_A = Math.max(A, C);
        int topSide_A = Math.max(B, D);
        int downSide_A = Math.min(B, D);
        int leftSide_B = Math.min(E, G);
        int rightSide_B = Math.max(E, G);
        int topSide_B = Math.max(F, H);
        int downSide_B = Math.min(F, H);
        int area = 0;
        
        if(leftSide_A >= rightSide_B || leftSide_B >= rightSide_A || topSide_A <= downSide_B || topSide_B <= downSide_A){
            area = 0;
        } else {
            int left = Math.max(leftSide_A, leftSide_B);
            int right = Math.min(rightSide_A, rightSide_B);
            int up = Math.min(topSide_A, topSide_B);
            int down = Math.max(downSide_A, downSide_B);
            int length = right - left;
            int height = up - down;
            area = length * height;
        }

        int length_A = Math.abs(A - C);
        int heigth_A = Math.abs(B - D);
        int area_A = length_A * heigth_A;
        
        int length_B = Math.abs(E - G);
        int heigth_B = Math.abs(F - H);
        int area_B = length_B * heigth_B;
        
        return area_A + area_B - area;
        
    }
}
