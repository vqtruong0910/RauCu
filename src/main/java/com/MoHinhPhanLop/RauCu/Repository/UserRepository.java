package com.MoHinhPhanLop.RauCu.Repository;

import com.MoHinhPhanLop.RauCu.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
