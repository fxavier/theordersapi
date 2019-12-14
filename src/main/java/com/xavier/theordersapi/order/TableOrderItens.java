package com.xavier.theordersapi.order;

import com.xavier.theordersapi.model.OrderIten;
import com.xavier.theordersapi.model.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class TableOrderItens {

    private List<OrderIten> itens = new ArrayList<>();

    public BigDecimal getTotalPrice() {
        return itens.stream()
                .map(OrderIten::getTotalPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public void addIten(Product product, Integer quantity) {
        OrderIten orderIten = new OrderIten();
        orderIten.setProduct(product);
        orderIten.setQuantity(quantity);
        orderIten.setUnitPrice(product.getNewPrice());

        itens.add(orderIten);
    }
}
