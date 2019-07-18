package com.thoughtworks.parking_lot.Controller;

import com.thoughtworks.parking_lot.Respository.ParkingLotRepository;
import com.thoughtworks.parking_lot.model.ParkingLot;

@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @PostMapping
    public ParkingLot addParkinglot(@RequestBody ParkingLot parkingLot){
        return  parkingLotRepository.save(parkingLot);
    }
}
