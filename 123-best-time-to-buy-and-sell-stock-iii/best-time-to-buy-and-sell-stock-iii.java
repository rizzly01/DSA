class Solution {
    public int maxProfit(int[] prices) {
       
        if(prices==null || prices.length==0)
        {
            return 0;
        }
        int b1=Integer.MIN_VALUE;
        int c1=0;
        int b2=Integer.MIN_VALUE;
        int c2=0;

        for(int price:prices)
        {
                b1=Math.max(b1,-price);
                c1=Math.max(c1,b1+price);
                b2=Math.max(b2,c1-price);
                c2=Math.max(c2,b2+price);
        }
        return c2;
    }
}