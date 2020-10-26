package com.endie.avizandum.world.repository;

import com.endie.avizandum.world.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository  extends JpaRepository<District, Long> {

    District findOneByDistrictId(@Param("districtId") Long districtId);
}
