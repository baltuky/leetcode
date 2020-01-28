package com.leetcode;

public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        solve(solution, "aabcbc"); // true
        solve(solution, "abcabcababcc"); // true
        solve(solution, "abccba"); // false
        solve(solution, "cababc"); // false
        solve(solution, "cbbbbcaaaccbaabccabacabcacbabbabbcbacabacabcabbccbccbccbcaccbacaabaaababacbbccabbcbcbabbcba" +
                "bcacabcbababcaccbcbbbaaabbcbccaaabcbababaaaccbacbbcaabbacbbbabcccacbaacacccbcccbbbbccaaabaaababcbba" +
                "acbcccaaabcbacccaacbbbaabababbbbababcbaaaabbcacbacaaabbcacbccbbbbaabcacbccababaaaacbabbbaaccbccaaca" +
                "cccaaabacaaaacacbbaabcabcbcccbcabaaaccbcbaaaccaacbabcaabbccacbbcbbbcaccbaccacaabcbcccacacaccaabbcaa" +
                "ababbbbbbcabcbbacabbbbbaabcbabbbccaabccabccaaaccabcbcbabbcaccabcbaabaaabacccacacabbaccbabbbacaaabac" +
                "acabacbcabaabaccacbbaacbcaccaccbacbaacbcbabccbcacbbbcabaabaabbabbcbbbcbbaabababcacacacbcabbccbbbaca" +
                "cccbbbbbbcbabaacacbbbaccbcaaccaccabbabbcbaababbcacaababaababcccbbcaaaabccabbbcbbaacacabaabbaabcaaba" +
                "acaabcbaaabaccbbcbaaababcacaacabcbbbbabaccbabbccacbbbcbacccbbbcabaaaacacaacbbcabbbbaacacababccaaaca" +
                "ccaaaacbabbcacaabaacaaabcacaabcaaaaaaacbbabbababcbbccbabbabaccbbcccacaabcbccacaacbacbcccbababababab" +
                "bacbabacbcccccbbcbcbabbbbaacbbabacccbcccbcaccabacaacbbbabacccccbcbbbacaccacccbccbbbcbcbaacbbaabaacb" +
                "acabacacaaaccaaacabbbaabcaacacbaaabcbbbbcaacaaccbbbccbababcbcacbcbcbbaabcacbbcacaacacccababbcacbbca" +
                "accaacbbabccabbccbacacaccccccbcbbcbabcabbcaabbaabaccababcbcbcbabbcabcbabacaababcbcacbaacbcccbbbcbaa" +
                "cabcccbbabccacaaaaccaabccbbaabababcacabbaccbbacbcbcaacabbaccccabbccbbcabcbcccaabcccbabbacabccaacaba" +
                "bcaaaacccbabcccabcccabccbacaacabcbbaacbaacbbcbaaaacbbcaccbacaccaaaccabaaabcbabababbcbbcbacbabaacbbb" +
                "aacabbbaacbaccccaaccccabcabaabaccacaaacabbbbcbccccbcacaacbcbbbcbabcbccaaabbaccbaacccbaacbbbbcccacbc" +
                "acabccbbcbabbccabbbaabaacbbacacacccbcbcbaabcccacbccbbcacaababbcbaaabaccaaaaacbbbacaaaaabbacaabacbca" +
                "ccaacbacbaaaabcbaaabcccccbcacbccacbccccaacaaccbbcbabcbaacbbabbbbaabcacbaaacbbcabcbcbbbcabbbbcbcbacc" +
                "cbcaacaccccbcccacbbbbbacbccaabcbabcacacbbaccbbbaccbcaacacabaaccbccabbccbacbaacbbbbacacccabbbbabaaaa" +
                "bcbabcccacccababbabcabbbaabacbcbaaccccacbbbccccacaaaacabaacaccaabccacbbbccaabbccccbccbbbabacbabacba" +
                "bcbaccbabbaccaccbabcababbbbcbbcabababaacaccacbacccabcacbbbcccacacabcabccaacbacbcaccbaaaacbbccccccaa" +
                "bbabcbaaaacbbbaabbcacabaccabbcbbbbabbccabcccccbbcbbcccbbacacbaaacccccbbcaacaacabbbcacaaaaaacabacbbb" +
                "bbacbbacbbcbbbcbbaccaacbcbaaaabbbababbbccccaabacbcaacacbbcacccaacccccbbccbbbbbacbabcabbcacccbcbabba" +
                "abbacaabaacabcccbbbbcacabbbaacaaacbabbaccaacabbcbbaaabaccaccacccbbbacaccacbabbaacabbcbbcbbccbbbacbb" +
                "acbbbabcaababaacbaacaabbacbabbccccaccccaabbaaabcccabccbccaaacbbccabbbcbaaaacabbbbbbcbbacbbcccbbabba" +
                "cbbccbccccccaabacaabaaaccccaabcacbbccbbabccaacccaababbccbabcbabcccbbabaaaababaabbbcbabbccaacbacccaa" +
                "bccababccabcbbcccaacabbbcbaaabbcaacbbbaabaacbbacbbcacbcabccbbccbcbcbbcbaacacbbbbcacbabbaacccaccbacb" +
                "bcabbbbabcabaabbcaacabbbbbbccbacacaaacabaacbcbacbaaacabcbbcbbbabaccabaaaacaaaaaacaccbccaabaabcaaaba" +
                "aababcabcccbbcacbcacaabbaaacbbbbcbabaabaabacacaaccbaacabcacbaaabbacccbccaabbaccabbbbacbcbccbcbbcbcb" +
                "cbcabcccbccaacacccccbbbabbabcbcbabbacaabcbaabbacbcaccacacccacbabbabacababcbaccaabcbacabbacaaaabccbb" +
                "bbcaabbccbcccccbccacaababcccacbcbcbccabbcbcbcccccccacaaccbbccccbbbcabbacaacacbbabcaacacbcccacbcbcba" +
                "aaaccaabaaabcabcaacaacabaacccabaabbaac"); // false

        solve(solution, "aabbcc"); // false
    }

    private static void solve(Solution solution, String s) {
        System.out.printf("%s: %b\n", s, solution.isValid(s));
    }
}
