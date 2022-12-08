package com.MoHinhPhanLop.RauCu.Repository;

import com.MoHinhPhanLop.RauCu.Entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    @Query("FROM Product p JOIN fetch p.category c where category_id = c.id and c.name LIKE %?1%")
    public List<Product> searchCategory(String keyword);
    
   @Query("FROM Product where name LIKE %?1%")
   public List<Product> search(String keyword);
   
//   @Query("FROM Product p JOIN fetch p.orderDetail o where p.id = product_id group by product_id order by count(product_id) desc limit 1")
//   public List<Product> searchSelling();
   
   @Query(value="select *, count(product_id) AS \"Tongsanpham\" from product p, order_detail o where p.id = o.product_id group by product_id order by count(product_id) desc limit 5", nativeQuery=true)
   public List<Product> searchSelling();
}
