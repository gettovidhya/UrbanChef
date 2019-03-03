package in.shrividhya.urbanchef.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "recipe")
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    private int recipeId;

    @ColumnInfo(name = "chefId")
    private String chefId;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "info")
    private String info;

    @ColumnInfo(name = "tags")
    private String tags;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "nutritionDetails")
    private String nutritionDetails;

    @ColumnInfo(name = "ratings")
    private String ratings;

    @ColumnInfo(name = "reviews")
    private String reviews;

    @ColumnInfo(name = "ingredients")
    private String ingredients;

    @ColumnInfo(name = "directions")
    private String directions;

    @ColumnInfo(name = "createdBy")
    private String createdBy;

    @ColumnInfo(name = "createdAt")
    private String createdAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNutritionDetails() {
        return nutritionDetails;
    }

    public void setNutritionDetails(String nutritionDetails) {
        this.nutritionDetails = nutritionDetails;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
