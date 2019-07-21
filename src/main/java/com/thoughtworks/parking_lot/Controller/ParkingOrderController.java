package com.thoughtworks.parking_lot.Controller;

import com.thoughtworks.parking_lot.Respository.ParkingLotRepository;
import com.thoughtworks.parking_lot.Respository.ParkingOrderRepository;
import com.thoughtworks.parking_lot.Service.ParkingOrderService;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.model.ParkingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/parkingorder")
public class ParkingOrderController {
    @Autowired
    private ParkingOrderRepository parkingOrderRepository;
    @Autowired
    private ParkingOrderService parkingOrderService;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @PutMapping
    public  void updateParkingOrder(String number){
        parkingOrderService.deleteOrder(number);

    }
    @PostMapping("/{id}")
    public  String addParkingOrder(@PathVariable String id, @RequestBody ParkingOrder parkingOrder){
        ParkingLot parkingLot=parkingLotRepository.findById(id);
        if(parkingLot.getParkingOrders().size()>=parkingLot.getCapacity()){
            return  "创建失败，没有空余位置。";
        }else {
            parkingLot.getParkingOrders().add(parkingOrder);
            parkingLotRepository.save(parkingLot);
        }
        return  "创建成功。";
    }

}
