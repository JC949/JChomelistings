package com.JC.data;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.JC.model.HouseEntity;

public interface OrdersRepositoryInterface extends CrudRepository<HouseEntity, Long> {
    List<HouseEntity> findByProductNameContainingIgnoreCase(String searchTerm);   
}
