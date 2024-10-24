package com.Ebooks.Ebooks_api.UseCases.Order;

import com.Ebooks.Ebooks_api.Entity.Order;
import com.Ebooks.Ebooks_api.exception.Http.NotFoundException;
import com.Ebooks.Ebooks_api.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOrderByIdUseCase {
    private final OrderRepository orderRepository;

    public Order execute(Long id){
        return this.orderRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nenhum pedido encontrado"));
    }
}
