package com.thoughtworks.parking_lot.Respository;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingLotRepositoryTest {
    @Autowired
    private  ParkingLotRepository parkingLotRepository;
    @Test
    public  void should_return_correct_when_given_one_parkinglot(){
        ParkingLot parkingLot=new ParkingLot("lisi",100,"school");
        parkingLotRepository.save(parkingLot);
        assertEquals(1,parkingLotRepository.findAll().size());
    }
}
