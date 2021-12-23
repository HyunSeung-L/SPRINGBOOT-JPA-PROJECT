package jpabook.jpashop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Builder;
import lombok.Getter;

@Entity
@DiscriminatorValue("B")
@Getter
public class Book extends Item {
    private String author;
    private String isbn;

    public Book(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}
