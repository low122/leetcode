class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        char[] genes = {'A', 'C', 'G', 'T'};

        queue.add(startGene);
        seen.add(startGene);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currGene = queue.remove();

                if (currGene.equals(endGene)) {
                    return count;
                }

                // Only change one char for each iteration
                char[] geneArray = currGene.toCharArray();
                for (int j = 0; j < geneArray.length; j++) {
                    char oldChar = geneArray[j];
                    for (char c : genes) {
                        if (c == oldChar) {
                            continue;
                        }

                        geneArray[j] = c;
                        String mutated = new String(geneArray);

                        if (bankSet.contains(mutated) && !seen.contains(mutated)) {
                            queue.add(mutated);
                            seen.add(mutated);
                        }
                    }

                    // Change it back to original cuz we might need to reverse back
                    geneArray[j] = oldChar;
                }
            }

            count++;
        }

        return -1;
    }
}