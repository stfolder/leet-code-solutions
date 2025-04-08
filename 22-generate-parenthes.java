class Solution {

    private List<String> generateStrings(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i <= sb.length(); i++) {
            sb.insert(i, '(');
            int counter = 0;
            for (int j = i + 1; j < sb.length(); j++) {
                if (counter == 0) {
                    sb.insert(j, ')');
                    result.add(sb.toString());
                    sb.deleteCharAt(j);
                }
                char c = sb.charAt(j);
                if (c == '(') counter++;
                else counter--;

            }
            sb.deleteCharAt(i);
        }
        return result.stream().distinct().collect(Collectors.toList());
    }


    private List<String> buildTrees(int n) {
        if (n == 1) {
            List result = new ArrayList();
            result.add("()");
            return result;
        }
        List<String> results = buildTrees(n - 1);
        return results.stream().flatMap(s -> generateStrings(s).stream()).collect(Collectors.toList());
    }

    public List<String> generateParenthesis(int n) {
        return buildTrees(n).stream().distinct().collect(Collectors.toList());
    }
}
