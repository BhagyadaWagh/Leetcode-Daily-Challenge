public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for(int num : arr)
        {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);

            for(int prevVal : prev)
            {
                curr.add(num | prevVal);
            }


            prev = curr;
            res.addAll(curr);
        }

        return res.size();
    }
}{

}
