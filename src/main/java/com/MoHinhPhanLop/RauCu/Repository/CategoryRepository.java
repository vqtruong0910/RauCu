package com.MoHinhPhanLop.RauCu.Repository;

import com.MoHinhPhanLop.RauCu.Entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
