package com.sosimplebox.dao.db2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sosimplebox.model.db2.Server;


@Repository
public interface ServerDaoRepository extends JpaRepository<Server, String> {

}
