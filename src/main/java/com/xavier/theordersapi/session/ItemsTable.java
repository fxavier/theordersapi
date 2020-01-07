package com.xavier.theordersapi.session;

import com.xavier.theordersapi.model.OrderItem;
import com.xavier.theordersapi.model.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


@Component
@Data
public class ItemsTable {

    private List<OrderItem> items = new ArrayList<>();

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(OrderItem::getSubtotal)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public void addItem(Product product, Integer quantity) {
        Optional<OrderItem> foundOrderItem = getItemByProduct(product);

        OrderItem orderItem = null;
        if (foundOrderItem.isPresent()) {
            orderItem = foundOrderItem.get();
            orderItem.setQuantity(orderItem.getQuantity() + quantity);
        } else {
            orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setUnitPrice(product.getNewPrice());
            items.add(0, orderItem);
        }
    }

    public void updateQuantity(Product product, Integer quantity) {
        OrderItem orderItem = getItemByProduct(product).get();
        orderItem.setQuantity(quantity);
    }

    public void removeItem(Product product) {
        int index = IntStream.range(0, items.size())
                .filter(i -> items.get(i).getProduct().equals(product))
                .findAny().getAsInt();
        items.remove(index);
    }

    public int total() {
        return items.size();
    }

    public Optional<OrderItem> getItemByProduct(Product product) {
       return items.stream()
                .filter(i -> i.getProduct().equals(product))
                .findAny();
    }
}
