package Tree.DP;

import java.util.*;

public class LC_2353_DesignFoodRating {
    static class FoodRatings {

        Map<String, List<FoodRating>> map = new HashMap<>();
        Map<String,String> foodToCuisineMapping = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {


            for(int i=0;i<ratings.length;i++) {
                map.computeIfAbsent(cuisines[i],k->new ArrayList<>());
                foodToCuisineMapping.put(foods[i],cuisines[i]);

                FoodRating food = new FoodRating(foods[i],ratings[i]);
                List<FoodRating> foodList = map.get(cuisines[i]);
                foodList.add(food);
                map.put(cuisines[i],foodList);
            }
        }

        public void changeRating(String food, int newRating) {
            List<FoodRating> foodList = map.get(foodToCuisineMapping.get(food));

            for(int i =0;i<foodList.size();i++) {
                if(food.equalsIgnoreCase(foodList.get(i).getFood())) {
                    foodList.get(i).setRating(newRating);
                }
            }
        }

        public String highestRated(String cuisine) {
            return map.get(cuisine).get(0).getFood();
        }
    }

   static class FoodRating {
        private int rating;
        private String food;

        public FoodRating(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }

        public int getRating() {
            return rating;
        }

        public String getFood() {
            return food;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

    }

    public static void main(String[] args) {
        FoodRatings obj = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        obj.changeRating("sushi",16);
        System.out.println( obj.highestRated("japanese"));

        obj.changeRating("ramen",16);
        System.out.println( obj.highestRated("japanese"));
    }

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
}
