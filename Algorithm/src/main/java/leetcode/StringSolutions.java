package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class StringSolutions {

    /**
     * 无重复字符的最长子串
     *
     * 维护了一个滑动窗口，窗口内的都是没有重复的字符，我们需要尽可能的扩大窗口的大小。由于窗口在不停向右滑动，所以我们只关心每个字符最后出现的位置，并建立映射。窗口的右边界就是当前遍历到的字符的位置，为了求出窗口的大小，我们需要一个变量left来指向滑动窗口的左边界，这样，如果当前遍历到的字符从未出现过，那么直接扩大右边界，如果之前出现过，那么就分两种情况，在或不在滑动窗口内，如果不在滑动窗口内，那么就没事，当前字符可以加进来，如果在的话，就需要先在滑动窗口内去掉这个已经出现过的字符了，去掉的方法并不需要将左边界left一位一位向右遍历查找，由于我们的HashMap已经保存了该重复字符最后出现的位置，所以直接移动left指针就可以了。我们维护一个结果res，每次用出现过的窗口大小来更新结果res，就可以得到最终结果了。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c));
            }
            res = Math.max(res, right - left + 1);
            map.put(c, right+1);
        }
        return  res;
    }

    /**
     * 最长公共前缀
     *
     * 将任意一个成员字符串作为初始prefix，遍历 strs，如果 prefix 是最长公共字串，就验证下一个成员字符串；否则将 prefix 截短一位；重复。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (String s: strs) {
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 字符串的排列
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for(char c: s1.toCharArray()) {
            c1[c - 'a']++;
        }

        for(int right = len1 - 1; right < len2; right++) {
            int left = right - len1 + 1;
            c2 = new int[26];
            for(int j = left; j <= right; j++) {
                c2[s2.charAt(j) - 'a']++;
            }
            if (Arrays.equals(c1, c2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串相乘
     *
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] pos = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int cur10 = i + j;
                int cur1 = cur10 + 1;
                int realMul = mul + pos[cur1];

                pos[cur10] += realMul / 10;
                pos[cur1] = realMul % 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int p: pos) {
            if (builder.length() != 0 || p != 0) {
                builder.append(p);
            }
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

    /**
     * 翻转字符串里的单词
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strs = s.split(" ");

        List<String> filtered = Arrays.stream(strs).filter(string -> !string.isEmpty()).collect(Collectors.toList());
        Collections.reverse(filtered);

        return String.join(" ", filtered);
    }

    /**
     * 简化路径
     *
     * 重复连续出现的'/'，只按1个处理，即跳过重复连续出现的'/'；
     * 如果路径名是"."，则不处理；
     * 如果路径名是".."，则需要弹栈，如果栈为空，则不做处理；
     * 如果路径名为其他字符串，入栈。
     * 最后，再逐个取出栈中元素（即已保存的路径名），用'/'分隔并连接起来，不过要注意顺序呦。
     *
     * @param
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        List<String> ignored = Arrays.asList(new String[]{".", "", ".."});

        String[] tokens = path.split("/");
        for (String token : tokens) {
            if (!ignored.contains(token)) {
                stack.push(token);
            }
            if (!stack.isEmpty() && token.equalsIgnoreCase("..")) {
                stack.pop();
            }
        }
        return "/" + String.join("/", stack);
    }

    /**
     * 复原IP地址
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        return null;
    }
}
