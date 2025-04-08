class Solution {
    public int candy(int[] ratings) {
        int candies = 1;
        int total = 1;
        int decreaseLength = 0;

        int i = 1;
        while (i < ratings.length) {

            if (ratings[i-1] > ratings[i]) {
                decreaseLength++;
                if (i == ratings.length - 1 || ratings[i] <= ratings[i + 1]) {
                    total += (decreaseLength * (decreaseLength + 1)) /2 + (candies <= decreaseLength ? decreaseLength + 1 - candies : 0); // Sum of all except first decreasing + if(already added is less then needed) {first decreasing(length + 1 - already addedd)} 
                    candies = 1;
                    decreaseLength = 0;
                }
            }

            if (ratings[i] == ratings[i-1]) {
                candies = 1;
                total += 1;
            }

            if (ratings[i] > ratings[i-1]) {
                candies++;
                total += candies;
            }

            i++;
        }

        return total;
        
    }
}
