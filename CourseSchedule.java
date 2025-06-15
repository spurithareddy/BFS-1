// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
Calculating the indegree array and adjacency list for the vertices
Find all courses where indegree=0(completely independent) and add them to queue
process queue and go to all the adjacent elements and reduce the indegree.
In any case it becomes 0 , then add it to queue to process courses dependent on it
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //indegree array
        int[] inDegree = new int[numCourses];
        //adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        //Add all independent courses to a Queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int processedCourses = 0;
        while (!queue.isEmpty()) {
            //pop the independent coures
            int course = queue.poll();
            //increase the processed count
            processedCourses++;
            //Reduce the indegree of all the adjacent courses and if 0 add to queue
            for (int nextCourse : adj.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        //If all the courses become independent then return true
        return processedCourses == numCourses;
    }
}