package LeetCode;

import java.util.*;

public class Main1202 {

    public static void main(String[] args) {
        System.out.println(smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2))));
        System.out.println(smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2))));
        System.out.println(smallestStringWithSwaps("cba", Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2))));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        Map<Integer, Set<Integer>> unionMap = getUnionList(s.length(), pairs);
        Map<Character, List<Character>> charMap = new HashMap<>(unionMap.size());
        List<Character> minCharList = new ArrayList<>(unionMap.size());
        for (Map.Entry<Integer, Set<Integer>> entry : unionMap.entrySet()) {
            List<Character> chars = new ArrayList<>(entry.getValue().size());
            for(Integer item : entry.getValue()) {
                chars.add(s.charAt(item));
            }
            Collections.sort(chars);
            charMap.put(chars.get(0), chars);
            minCharList.add(chars.get(0));
        }
        Collections.sort(minCharList);
        StringBuilder stringBuilder = new StringBuilder();
        for (Character minCh : minCharList) {
            List<Character> characters = charMap.get(minCh);
            for (Character ch : characters) {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    private static Map<Integer, Set<Integer>> getUnionList(int length, List<List<Integer>> pairs) {

        Map<Integer, Set<Integer>> unionMap = new HashMap<>();
        // 构造并查集
        int[] parents = new int[length];
        for (int i = 0; i < length; i++) {
            parents[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int parent0 = findParent(pair.get(0), parents);
            int parent1 = findParent(pair.get(1), parents);
            parents[parent1] = parent0;
        }
        // 根据并查集构造集合
        for (int i = 0; i < length; i++) {
            int parent = findParent(i, parents);
            if (unionMap.containsKey(parent)) {
                unionMap.get(parent).add(i);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                unionMap.put(parent, set);
            }
        }
        return unionMap;
    }

    private static int findParent(int i, int[] parents) {
        if (parents[i] != i) {
            return findParent(parents[i], parents);
        }
        return parents[i];
    }
}
