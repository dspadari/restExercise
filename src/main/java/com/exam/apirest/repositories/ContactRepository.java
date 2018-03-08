package com.exam.apirest.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exam.apirest.model.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact,Long> {

    @Query("select e from #{#entityName} e where e.idContact = ?1")
    public Contact findByIdContact(Integer idContact);

    @Query("select e from #{#entityName} e where e.email = ?1")
    public Contact findByEmail(String email);

    @Query("select c from Contact c inner join c.address where (?1 is null or c.address.state = ?1) and (?2 is null or c.address.city = ?2)")
    //@Query("select c from Contact where c.")
    public Page<Contact> findAllByStateOrCity(String state, String city, Pageable pageable);

}
