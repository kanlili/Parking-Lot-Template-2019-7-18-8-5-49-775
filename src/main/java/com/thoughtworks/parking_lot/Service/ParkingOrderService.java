package com.thoughtworks.parking_lot.Service;

import com.thoughtworks.parking_lot.Respository.ParkingOrderRepository;
import com.thoughtworks.parking_lot.model.ParkingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

public class ParkingOrderService {
    @Autowired
    private ParkingOrderRepository parkingOrderRepository;
    public List<ParkingOrder> deleteOrder(String number){
         int id;
         for(ParkingOrder parkingOrder:parkingOrderRepository.findAll()){
             if(parkingOrder.getNumber()==number){
                 id=parkingOrder.getId();
             }
         }
        parkingOrderRepository.findById(id).get().setEndTime(new Date()) ;
        parkingOrderRepository.findById(id).get().setStatus(false);
        return  parkingOrderRepository.findAll();


     }
}
