package com.MoHinhPhanLop.RauCu.Repository;

import com.MoHinhPhanLop.RauCu.Entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
}
