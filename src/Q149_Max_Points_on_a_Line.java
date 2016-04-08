import java.util.HashMap;


public class Q149_Max_Points_on_a_Line {
	public int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        
        int maxLen = 0;
        int zero = 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        double result = 0;
        
        for(int i = 0; i < points.length; ++i){
            if(points[i].x == 0 && points[i].y == 0){
                zero++;
                continue;
            } else if(points[i].x == 0 && points[i].y != 0){
                result = 0;
            } else if(points[i].x != 0 && points[i].y == 0){
                result = Double.MAX_VALUE;
            } else {
                result = (double) points[i].x / (double) points[i].y;
            }
            
            int preNum = 0;
            if(map.containsKey(result)){
                preNum = map.get(result);
            }
            map.put(result, preNum + 1);
            maxLen = Math.max(maxLen, preNum + 1);
        }
        
        maxLen += zero;
        return maxLen;
    }
	
	class Point{
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
}
