package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyzhotel.model.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType,Integer> {
}
