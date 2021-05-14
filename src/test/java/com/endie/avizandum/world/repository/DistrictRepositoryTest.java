package com.endie.avizandum.world.repository;

import com.endie.avizandum.world.model.District;
import com.endie.avizandum.world.repository.DistrictRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class DistrictRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    DistrictRepository districtRepository;

    @Test
    public void should_find_no_districts_if_repository_is_empty() {
        Iterable<District> districts = districtRepository.findAll();

        assertThat(districts).isEmpty();
    }

    @Test
    public void should_store_a_district() {
        District district = districtRepository.save(new District("Test name", 1L));

        assertThat(district).hasFieldOrPropertyWithValue("name", "Test name");
        assertThat(district).hasFieldOrPropertyWithValue("terrainId", 1L);
    }

    @Test
    public void should_find_all_districts() {
        District district1 = new District("A Test 1 name", 1L);
        entityManager.persist(district1);

        District district2 = new District("B Test 2 name", 2L);
        entityManager.persist(district2);

        District district3 = new District("C Test 3 name", 3L);
        entityManager.persist(district3);

        Iterable<District> districts = districtRepository.findAll();

        assertThat(districts).hasSize(3).contains(district1, district2, district3);
    }

    @Test
    public void should_find_district_by_id() {

        District district1 = new District("D Test 1 name", 1L);
        entityManager.persist(district1);

        District district2 = new District("E Test 2 name", 2L);
        entityManager.persist(district2);

        District foundDistrict = districtRepository.findById(district2.getDistrictId()).get();

        assertThat(foundDistrict).isEqualTo(district2);

    }

    @Test
    public void should_update_district_by_id() {
        District district1 = new District("F District 1 name", 1L);
        entityManager.persist(district1);

        District district2 = new District("G District 2 name", 2L);
        entityManager.persist(district2);

        District updatedDistrict = new District("H updated District 2 name", 3L);

        District district = districtRepository.findById(district2.getDistrictId()).get();
        district.setName(updatedDistrict.getName());
        district.setTerrainId(updatedDistrict.getTerrainId());
        districtRepository.save(district);

        District checkDistrict = districtRepository.findById(district2.getDistrictId()).get();

        assertThat(checkDistrict.getDistrictId()).isEqualTo(district2.getDistrictId());
        assertThat(checkDistrict.getName()).isEqualTo(updatedDistrict.getName());
        assertThat(checkDistrict.getTerrainId()).isEqualTo(updatedDistrict.getTerrainId());

    }

    @Test
    public void should_delete_all_districts() {
        entityManager.persist(new District("District #1", 1L));
        entityManager.persist(new District("District #2", 2L));

        districtRepository.deleteAll();

        assertThat(districtRepository.findAll()).isEmpty();
    }
}
