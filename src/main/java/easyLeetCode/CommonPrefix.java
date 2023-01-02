package easyLeetCode;


//"flower" "flow" "flight"
class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int j = 0;
        int k = 1;
        StringBuilder answer = new StringBuilder(strs[0]);


        if (strs.length == 1) {
            return strs[0];
        }
        if (strs.length > 1) {
            while (k < strs.length) {
                while (j < answer.length() && j < strs[k].length() && answer.charAt(j) == strs[k].charAt(j)) {
                    j++;
                }
                answer = new StringBuilder(strs[0].substring(0, j));
                if (j == 0) {
                    return "";
                }
                j = 0;
                k++;
            }
        }
        return answer.toString();
    }
}