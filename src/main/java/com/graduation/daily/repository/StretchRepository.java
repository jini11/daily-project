package com.graduation.daily.repository;

import com.graduation.daily.model.Stretch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StretchRepository extends JpaRepository<Stretch, Long> {
    List<Stretch> findAll();
    //List<Stretch> findBySearch(String searchText);

}
