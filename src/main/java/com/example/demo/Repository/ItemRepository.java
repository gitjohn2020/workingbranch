package com.example.demo.Repository;

import com.example.demo.Beans.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Books,Integer> {

  public Books findById(int id);
}
