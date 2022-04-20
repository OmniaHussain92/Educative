/*
Longest Substring with maximum K Distinct Characters
Problem Statement#
Given a string, find the length of the longest substring in it with no more than K distinct characters.
Example 1:
- Input: String="araaci", K=2
- Output: 4
- Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:
- Input: String="araaci", K=1
- Output: 2
- Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:
- Input: String="cbbebi", K=3
- Output: 5
- Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
Example 4:
- Input: String="cbbebi", K=10
- Output: 6
- Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
*/

import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    // validate input
    if(str == null || str.length() == 0 || k== 0)
      return 0;

    if(str.length() < k)
      return 0;

    int curDistinctLength = 0; // to keep track of current window length
    int maxDistictLenght = 0;
    int leftIndex = 0;
    int rightIndex = 0;

    // Hashset to keep track of the distinct characters found
    HashSet<String> foundChar = new HashSet<String>();

    while(leftIndex < str.length()){
      if(foundChar.contains(String.valueOf(str.charAt(rightIndex)))){
          rightIndex++;
          curDistinctLength++;
      }
      else if(foundChar.size() < k)
      {
          foundChar.add(String.valueOf(str.charAt(rightIndex)));
          curDistinctLength++;
          rightIndex++;
      }
      else
      {
        maxDistictLenght = Math.max(maxDistictLenght, curDistinctLength);
        curDistinctLength = 0;
        foundChar.clear();
        leftIndex ++;
        rightIndex = leftIndex;
      }

      if(rightIndex == str.length()){
        foundChar.clear();
        curDistinctLength = 0;
        leftIndex ++;
        rightIndex = leftIndex;
      }
    }

    return maxDistictLenght;
  }
}
