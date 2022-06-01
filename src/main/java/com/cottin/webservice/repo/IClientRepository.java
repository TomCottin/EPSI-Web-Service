package com.cottin.webservice.repo;

import java.util.Optional;

import com.cottin.webservice.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findById(int Id);

    @Query(value = "FROM Client c WHERE " +
            "lower(last_name) LIKE :lastName% AND " +
            "lower(first_name) LIKE :firstName% AND " +
            "lower(address) LIKE :address% AND " +
            "lower(city) LIKE :city% AND " +
            "lower(zip_code) LIKE :zipCode%")
    Optional<Iterable<Client>> findClientWithAllParams(
            @Param("lastName") String lastName,
            @Param("firstName") String firstName,
            @Param("address") String address,
            @Param("city") String city,
            @Param("zipCode") String zipCode);

}
