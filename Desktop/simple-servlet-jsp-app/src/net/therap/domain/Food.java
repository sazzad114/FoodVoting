package net.therap.domain;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 4/19/12
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Food {

    private int foodId;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodImageLink() {
        return foodImageLink;
    }

    public void setFoodImageLink(String foodImageLink) {
        this.foodImageLink = foodImageLink;
    }

    private String foodName;
    private String foodImageLink;
}