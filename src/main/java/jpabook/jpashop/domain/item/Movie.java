package jpabook.jpashop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("M")
@Getter
public class Movie extends Item {

    private String director;
    private String actor;

    public Movie(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}
