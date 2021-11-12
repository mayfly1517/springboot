package leetcode.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
     static List<String> ret=new ArrayList<>();

    public static void main(String[] args){

        permutation("abb");
    }

    public static void permutation(String s) {
        char[]chars=s.toCharArray();
        Arrays.sort(chars);
        backtracking(chars,new boolean[chars.length],new StringBuilder());
        String[]res=new String[ret.size()];
        for(int i=0;i<ret.size();i++){
            res[i]=ret.get(i);
            System.out.println(res[i]);
        }

    }

    static void backtracking(char[]chars,boolean[]visited,StringBuilder sb){
        if(sb.length()==chars.length){
            ret.add(sb.toString());
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(visited[i])continue;
            if(i!=0&&chars[i]==chars[i-1]&&!visited[i-1])continue;
            visited[i]=true;//标记状态
            sb.append(chars[i]);
            backtracking(chars,visited,sb);//dfs搜索
            sb.deleteCharAt(sb.length()-1);
            visited[i]=false;//清楚标记
        }

    }
}
