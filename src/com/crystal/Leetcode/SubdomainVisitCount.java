package com.crystal.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

    public static void main (String args[]) {

        String[] input = { "9001 discuss.leetcode.com" };
        List<String> answer = subdomainVisits(input);
        for (String answerString : answer) {
            System.out.println(answerString);
        }

    }

    static public List<String> subdomainVisits(String[] cpdomains) {
       Map<String, Integer> counts = new HashMap<>();
       for (String domain : cpdomains) {
           String[] cpinfo = domain.split("\\s+");
           String[] frags = cpinfo[1].split("\\.");
           int count = Integer.valueOf(cpinfo[0]);
           String cur = "";
           for (int i = frags.length - 1; i >= 0; --i) {
               cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
               counts.put(cur, counts.getOrDefault(cur, 0 ) + count);
           }
       }

       List<String> ans = new ArrayList<>();
       for (String dom: counts.keySet())
           ans.add("" + counts.get(dom) + " " + dom);
       return ans;
    }



}
