package project.utils;

import framework.BaseEntity;

import java.util.Objects;

/**
 * Created by a.maley on 25.10.2016.
 */
public class GameInfo extends BaseEntity{
    private String discount;
    private String price;

    public String getDiscount() {
        return discount;
    }

    public String getPrice() {
        return price;
    }

    public GameInfo(final String discount, final String price){
        this.price = price;
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameInfo gameInfo = (GameInfo) o;
        return Objects.equals(discount, gameInfo.discount) &&
                Objects.equals(price, gameInfo.price);
    }


}
