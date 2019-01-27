package algorithm;

import java.util.*;

public class WrodLadder {

    public static List<List<String>> findLadder(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        HashMap<String, ArrayList<String>> nexts = getNexts(wordList);
        HashMap<String, Integer> distances = getDistances(beginWord, nexts);
        LinkedList<String> pathList = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        getShortestPaths(beginWord, endWord, nexts, distances, pathList, res);
        return res;

    }

    private static HashMap<String, ArrayList<String>> getNexts(List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            nexts.put(wordList.get(i), new ArrayList<>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            nexts.put(wordList.get(i), getNext(wordList.get(i), set));
        }
        return nexts;
    }

    private static ArrayList<String> getNext(String word, Set<String> set) {
        ArrayList<String> res = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (char cur = 'a'; cur <= 'z'; cur++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] != cur) {
                    char tmp = chs[i];
                    chs[i] = cur;
                    if (set.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = tmp;
                }
            }
        }
        return res;
    }

    private static void getShortestPaths(String cur, String endWord,
                                         HashMap<String, ArrayList<String>> nexts,
                                         HashMap<String, Integer> distances,
                                         LinkedList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (endWord.equals(cur)) {
            res.add(new LinkedList<String>(solution));
        } else {
            for (String next : nexts.get(cur)) {
                if (distances.get(next) == distances.get(cur) + 1) {
                    getShortestPaths(next, endWord, nexts, distances, solution, res);
                }
            }
        }
        solution.pollLast();
    }

    // 宽度优先遍历
    private static HashMap<String, Integer> getDistances(String beginWord, HashMap<String, ArrayList<String>> nexts) {
        HashMap<String, Integer> distances = new HashMap<>();
        distances.put(beginWord, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        HashSet<String> visted = new HashSet<>();
        visted.add(beginWord);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String str : nexts.get(cur)) {
                if (!visted.contains(str)) {
                    distances.put(str, distances.get(cur) + 1);
                    queue.add(str);
                    visted.add(str);
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        List<String> array = new ArrayList<String>();
        array.add("hot");
        array.add("dot");
        array.add("dog");
        array.add("lot");
        array.add("log");
        array.add("cog");
        List<List<String>> res = findLadder("hit", "cog", array);
        System.out.println(res);
    }

}
