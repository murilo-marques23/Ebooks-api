package com.Ebooks.Ebooks_api.UseCases.Order;

import com.Ebooks.Ebooks_api.Dto.Input.CreateOrderDto;
import com.Ebooks.Ebooks_api.Entity.Book;
import com.Ebooks.Ebooks_api.Entity.Order;
import com.Ebooks.Ebooks_api.Entity.OrderItem;
import com.Ebooks.Ebooks_api.UseCases.Book.FindBookById;
import com.Ebooks.Ebooks_api.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {
    private final OrderRepository orderRepository;
    private final FindBookById findBookById;

    @Transactional
    public Order execute(Long userId, CreateOrderDto order){
        List<OrderItem> orderItemList= new ArrayList<>();

        Long totalPrice = order.getBook().stream().map(bookOrder -> {
            Book book = this.findBookById.execute(bookOrder.getProductId());

            OrderItem item = new OrderItem();
            item.setBookId(book.getId());
            item.setQuantity(bookOrder.getQuantity());
            item.setUnitPrice(book.getPreco());
            orderItemList.add(item);

            return book.getPreco() * bookOrder.getQuantity();
        }).reduce(0L, Long::sum);

        Order orderToStore = new Order();

        orderToStore.setUserId(userId);
        orderToStore.setTotalPrice(totalPrice);
        orderToStore.setOrderItems(orderItemList);

        return this.orderRepository.save(orderToStore);

    }
}
