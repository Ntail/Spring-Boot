package cn.timebusker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BasicRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {


}
