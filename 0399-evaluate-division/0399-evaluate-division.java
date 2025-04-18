class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {


        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double number = values[i];
            String dividend = equation.get(0); 
            String divisor = equation.get(1);

            if (!graph.containsKey(dividend)) {
                graph.put(dividend, new HashMap<String, Double>());
            }

            if (!graph.containsKey(divisor)) {
                graph.put(divisor, new HashMap<String, Double>());
            }

            graph.get(dividend).put(divisor, number);
            graph.get(divisor).put(dividend, 1/number);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1;
            } else if (dividend == divisor) {
                results[i] = 1;
            } else {
                HashSet<String> visited = new HashSet<>();
                results[i] = dfs(graph, dividend, divisor, 1, visited);
            }
        }

        return results;

    }

    private double dfs(HashMap<String, HashMap<String, Double>> graph, String currNode, String targetNode, double accProduct, Set<String> visited) {

        // mark the visit
        visited.add(currNode);
        double ret = -1.0;

        Map<String, Double> neighbors = graph.get(currNode);
        if (neighbors.containsKey(targetNode))
            ret = accProduct * neighbors.get(targetNode);
        else {
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode = pair.getKey();
                if (visited.contains(nextNode))
                    continue;
                ret = dfs(graph, nextNode, targetNode,
                        accProduct * pair.getValue(), visited);
                if (ret != -1.0)
                    break;
            }
        }

        // unmark the visit, for the next backtracking
        visited.remove(currNode);
        return ret;
    }
}