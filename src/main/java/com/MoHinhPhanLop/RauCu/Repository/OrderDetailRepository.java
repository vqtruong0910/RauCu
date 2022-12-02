package com.MoHinhPhanLop.RauCu.Repository;

import com.MoHinhPhanLop.RauCu.Entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail,Long> {
}
