package com.example.tokyo2020;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface WishListAttractionDao {

    @Insert
    void insert(WishListAttraction wishlistattraction);

    @Query("Select * from wishlist_attraction_table where wishlist_attraction_table.emailid=:CurrentLogin")
    List<WishListAttraction> getWishListAttractions(String CurrentLogin);

    @Query("Select * from wishlist_attraction_table where name=:attractionName and  emailid=:CurrentLogin")
    List<WishListAttraction> queryUserWishListAttractions(String attractionName, String CurrentLogin);
}
