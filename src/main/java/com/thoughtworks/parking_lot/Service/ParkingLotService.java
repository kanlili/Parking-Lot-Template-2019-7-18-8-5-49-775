package com.thoughtworks.parking_lot.Service;

import com.thoughtworks.parking_lot.Respository.ParkingLotRepository;
import com.thoughtworks.parking_lot.model.ParkingLot;

import java.util.List;

public class ParkingLotService {
    @Autowired
    private ParkingLotRepository getParkingLotRepository;
    private ParkingLotRepository parkingLotRepository;
    public List<ParkingLot> queryParkinglot(int page,int pageSize){
        return  parkingLotRepository.findAll().subList(page-1,pageSize);
    }
}
