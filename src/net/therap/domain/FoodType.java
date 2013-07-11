package net.therap.domain;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/19/12
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodType {
    List<Food> foodList;
    Food votedFood;
    private int foodTypeId;
    private String foodTypeName;

    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public String getFoodTypeName() {
        return foodTypeName;
    }

    public void setFoodTypeName(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }


    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }


    public Food getVotedFood() {
        return votedFood;
    }

    public void setVotedFood(Food votedFood) {
        this.votedFood = votedFood;
    }

    @Override
        public boolean equals(Object foodType){
           if(foodType instanceof FoodType){
             return this.foodTypeName.equals(((FoodType)foodType).getFoodTypeName());
           }
           return false;
        }


}
