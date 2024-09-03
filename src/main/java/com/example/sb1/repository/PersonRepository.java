package com.example.sb1.repository;
 
 
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
 
import com.example.sb1.entity.Person;
 
 @Repository
public interface PersonRepository extends ListCrudRepository<Person, Long>{
   
   @Modifying
    @Query("insert into person (id, name,email) values(:id, :name, :email)")
    void addData (int id, String name,String email);
 
}