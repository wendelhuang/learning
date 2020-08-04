package com.sosimplebox.dao.db1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sosimplebox.model.db1.Order;


@Repository
public interface OrderDaoRepository extends JpaRepository<Order, Integer> {

}
