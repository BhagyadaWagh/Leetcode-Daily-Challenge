class Solution {
    public int maxSum(int[] nums) 
    {
        Set<Integer> uniqueElements = new HashSet<>();
        int res = 0;
        int maxNeg = Integer.MIN_VALUE;

        for(int num : nums)
        {
            if(num > 0)
            {
                uniqueElements.add(num);
            }
            else
            {
                maxNeg = Math.max(maxNeg, num);
            }
        }

        for(int num: uniqueElements)
        {
            res += num;
        }

        return res == 0 ? maxNeg : res;
    }
}