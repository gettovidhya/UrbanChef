package in.shrividhya.urbanchef.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Recipe {
    @PrimaryKey
    public int recipeId;

    @ColumnInfo(name = "chefId")
    public String chefId;

    @ColumnInfo(name = "category")
    public String category;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "info")
    public String info;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "nutritionDetails")
    public String nutritionDetails;

    @ColumnInfo(name = "ratings")
    public String ratings;

    @ColumnInfo(name = "reviews")
    public String reviews;

    @ColumnInfo(name = "ingredients")
    public String ingredients;

    @ColumnInfo(name = "directions")
    public String directions;

    @ColumnInfo(name = "createdBy")
    public String createdBy;

    @ColumnInfo(name = "createdAt")
    public String createdAt;
}
