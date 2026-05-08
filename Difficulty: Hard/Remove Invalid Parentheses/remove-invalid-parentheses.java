class Solution {
    public List<String> validParenthesis(String s) {
        // code here
         Set<String> resultSet = new LinkedHashSet<>();

        if (s == null || s.length() == 0) {
            resultSet.add("");
            return new ArrayList<>(resultSet);
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean foundValid = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (isValid(curr)) {
                    resultSet.add(curr);   // ← add to result, preserving BFS order
                    foundValid = true;
                }

                if (foundValid) continue;

                for (int j = 0; j < curr.length(); j++) {
                    if (curr.charAt(j) != '(' && curr.charAt(j) != ')') continue;

                    String next = curr.substring(0, j) + curr.substring(j + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            if (foundValid) break;
        }

        return new ArrayList<>(resultSet);
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}