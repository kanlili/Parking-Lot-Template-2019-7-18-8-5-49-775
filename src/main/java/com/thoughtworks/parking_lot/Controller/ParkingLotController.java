package com.thoughtworks.parking_lot.Controller;

import com.thoughtworks.parking_lot.Respository.ParkingLotRepository;
import com.thoughtworks.parking_lot.Service.ParkingLotService;
import com.thoughtworks.parking_lot.model.ParkingLot;

import java.util.List;

@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingLotService parkingLotService;
    @PostMapping
    public ParkingLot addParkinglot(@RequestBody ParkingLot parkingLot){
        return  parkingLotRepository.save(parkingLot);
    }
    @GetMapping(params = {"page","pageSize"})
    public List<ParkingLot> getParkinglot(@RequestParam int page,@RequestParam int pageSize){
     return  parkingLotService.queryParkinglot(page,pageSize);
    }
    @GetMapping("/{name}")
    public ParkingLot getParkinglot(@PathVariable String name){
         return parkingLotRepository.findByName(name);
    }
    @GetMapping
    public void updateCapacity(@RequestBody ParkingLot parkingLot){
         parkingLotService.addCapacity(parkingLot);
    }

}
