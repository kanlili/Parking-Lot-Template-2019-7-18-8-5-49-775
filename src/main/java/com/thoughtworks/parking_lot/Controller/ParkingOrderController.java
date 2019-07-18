package com.thoughtworks.parking_lot.Controller;

import com.thoughtworks.parking_lot.Respository.ParkingOrderRepository;
import com.thoughtworks.parking_lot.Service.ParkingOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/parkingorder")
public class ParkingOrderController {
    @Autowired
    private ParkingOrderRepository parkingOrderRepository;
    @Autowired
    private ParkingOrderService parkingOrderService;
    @PutMapping
    public  void updateParkingOrder(String number){
        parkingOrderService.deleteOrder(number);

    }

}
