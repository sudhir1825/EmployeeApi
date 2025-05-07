package com.example.employee.Repository;

import com.example.employee.Model.Emp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface empReposiory extends MongoRepository<Emp,Long> {
}
