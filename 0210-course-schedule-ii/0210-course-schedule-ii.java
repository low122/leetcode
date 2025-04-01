class Solution {
    
    public boolean dfs(int node, HashMap<Integer, List<Integer>> course, boolean[] visited, boolean[] onPath, Stack<Integer> order) {

        // cycle detect
        if (onPath[node]) return false;
        // check explored
        if (visited[node]) return true;
        
        visited[node] = true;
        onPath[node] = true;
        
        if (course.containsKey(node)) {
            for (int neighbor : course.get(node)) {
                if (!dfs(neighbor, course, visited, onPath, order)) {
                    return false; // if cycle detected, stop immediately
                }
            }
        }

        onPath[node] = false; // done exploring this path
        order.push(node); // add node to the order
        return true;
    }
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> courses = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        Stack<Integer> order = new Stack<>();
        int[] answer = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int courseWanted = prerequisites[i][0];
            int courseRequire = prerequisites[i][1];

            // Creating the graph
            if (!courses.containsKey(courseRequire)) {
                courses.put(courseRequire, new ArrayList<>());
            }

            // Confirm the courses has included the required course/prerequisite
            courses.get(courseRequire).add(courseWanted);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!dfs(i, courses, visited, onPath, order)) {
                    return new int[0]; // cycle detected, no valid ordering
                }
            }
        }

        int idx = 0;
        while (!order.isEmpty()) {
            answer[idx++] = order.pop();
        }
        return answer;
    }
}