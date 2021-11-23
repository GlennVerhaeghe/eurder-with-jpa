package com.switchfully.order.domain.orders;

import com.switchfully.order.domain.orders.orderitems.events.OrderItemCreatedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> getAllByCustomerId(UUID customerId);
}
