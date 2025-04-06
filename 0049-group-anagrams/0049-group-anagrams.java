class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<HashMap<Character, Integer>, List<String>> checker = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();
        

        for (int i = 0; i < strs.length; i++) {
            String currentStr = strs[i];
            HashMap<Character,Integer> count = new HashMap<>();

            for (int j = 0; j < currentStr.length(); j++) {
                char currentChar = currentStr.charAt(j);
                if (!count.containsKey(currentChar)) {
                    count.put(currentChar, 1);
                } else {
                    count.put(currentChar, count.get(currentChar) + 1);
                }

                System.out.println(currentChar);
            }

            if (!checker.containsKey(count)) {
                List<String> array = new ArrayList<>();
                array.add(currentStr);
                checker.put(count, array);
            } else {
                checker.get(count).add(currentStr);
            }
        }

        for (List<String> lists : checker.values()) {
            answer.add(lists);
        }

        return answer;
    }
}