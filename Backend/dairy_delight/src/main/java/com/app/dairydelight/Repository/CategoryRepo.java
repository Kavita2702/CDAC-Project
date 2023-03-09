package com.app.dairydelight.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dairydelight.model.Category;

public interface CategoryRepo  extends JpaRepository<Category, Long> {

}
