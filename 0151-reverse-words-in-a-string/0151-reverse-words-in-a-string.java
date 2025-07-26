class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] spliter = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = spliter.length-1; i >= 0;i--) {
            result.append(spliter[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}