import java.util.LinkedList;


public class Q207_Course_Schedule {
	private LinkedList<Integer>[] course;
	private int[] visited;
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses == 0) return true;
		visited = new int[numCourses];    // 共3态，1:通，－1:不通，0:未判断
		course = new LinkedList[numCourses];
		for(int i = 0; i < numCourses; ++i)
			course[i] = new LinkedList<Integer>();
		
		for(int i = 0, len = prerequisites.length; i < len; ++i)
			course[prerequisites[i][0]].add(prerequisites[i][1]);
		
		for(int i = 0; i < numCourses; ++i)
			if(!finish(i))
				return false;
	
		return true;
	}
	
	public boolean finish(int vertex){
		if(visited[vertex] == 1) return true;
		if(visited[vertex] == -1) return false;
		visited[vertex] = -1;
		for(int i : course[vertex]){
			if(!finish(i))
				return false;
		}
		visited[vertex] = 1;   // 通过
		return true;
	}

	
	public static void main(String[] args){
		Q207_Course_Schedule t = new Q207_Course_Schedule();
		int[][] prerequisites = {{0,1},{3,1},{1,3},{3,2}};
		System.out.println(t.canFinish(4, prerequisites));
	}
}
