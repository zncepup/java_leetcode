import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring_with_Concatenation {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> l = new ArrayList<>();
            if (null == s || 0 == s.length() || null == words || 0 == words.length)
                return l;
            int sLen = s.length(), wLen = words[0].length(), wsLen = words.length;
            if (sLen < wLen * wsLen)
                return l;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < wsLen; i++) {
                map.put(words[i], map.containsKey(words[i]) ? map.get(words[i]) + 1 : 1);
            }
            for (int i = 0; i < wLen; i++) {
                int left = i, right = i, windows = 0;
                while (right + (wsLen - windows) * wLen <= sLen && right + wLen <= sLen)
                {
                    String word = s.substring(right, right + wLen);
                    if (map.containsKey(word))
                    {
                        int count = map.get(word);
                        windows++;
                        if (count > 0)
                        {
                            map.put(word, count - 1);
                        }
                        else
                        {
                            String removed = s.substring(left, left + wLen);
                            while (!removed.equals(word))
                            {
                                map.put(removed, map.get(removed) + 1);
                                windows--;
                                left += wLen;
                                removed = s.substring(left, left + wLen);
                            }
                            windows--;
                            left += wLen;
                        }

                        if (windows == wsLen)
                            l.add(left);

                    }
                    else
                    {
                        windows = 0;
                        while (left < right){
                            String removed = s.substring(left, left + wLen);
                            map.put(removed, map.get(removed) + 1);
                            left += wLen;
                        }
                        left += wLen;
                    }
                    right += wLen;
                }
                while (left < right)
                {
                    String removed = s.substring(left, left + wLen);
                    map.put(removed, map.get(removed) + 1);
                    left += wLen;
                }
            }
            return l;
        }
    }
    public static void main(String[] ARGS){

    }
}
