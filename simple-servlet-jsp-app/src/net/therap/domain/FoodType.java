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

    private int foodTypeId;
    private String foodTypeName;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public boolean isAlreadyVoted() {
        return alreadyVoted;
    }

    public void setAlreadyVoted(boolean alreadyVoted) {
        this.alreadyVoted = alreadyVoted;
    }

    List<Food> foodList;
    boolean alreadyVoted;
}
