package com.wallace.productservice.repository;

import com.wallace.productservice.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
}
