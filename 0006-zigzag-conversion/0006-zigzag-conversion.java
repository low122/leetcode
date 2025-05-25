class Solution {

    public String convert(String s, int numRows) {
        int strLength = s.length();
        String result = "";

        if (numRows == 1 || strLength < numRows) return s;

        for (int i = 0; i < numRows; i++) {
            int pointer = (numRows - 1) * 2;
            for (int j = i; j < strLength; j+=pointer) {
                result += s.charAt(j);
                if (i > 0 && i < numRows - 1 && (j + pointer - 2 * i) < strLength) {
                    result += s.charAt(j + pointer - 2 * i);
                }
            }
        }

        return result;
    }
}