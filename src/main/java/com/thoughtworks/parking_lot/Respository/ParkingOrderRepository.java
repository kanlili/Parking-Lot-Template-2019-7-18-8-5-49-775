package com.thoughtworks.parking_lot.Respository;

import com.thoughtworks.parking_lot.Service.ParkingOrderService;
import com.thoughtworks.parking_lot.model.ParkingOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingOrderRepository extends JpaRepository<ParkingOrderService,Integer> {
    ParkingOrder findByCarNumber (String CarNumber);
}
