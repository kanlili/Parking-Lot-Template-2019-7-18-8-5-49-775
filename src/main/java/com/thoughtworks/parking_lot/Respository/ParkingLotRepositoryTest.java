package com.thoughtworks.parking_lot.Respository;

import com.thoughtworks.parking_lot.Service.ParkingLotService;
//import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingLotRepositoryTest {
    @Autowired
    private  ParkingLotRepository parkingLotRepository;
    @Autowired
    private  ParkingLotService parkingLotService;
    @Test
    public  void should_return_correct_when_given_one_parkinglot(){
        ParkingLot parkingLot=new ParkingLot("lisi",100,"school");
        parkingLotRepository.save(parkingLot);
        assertEquals(1,parkingLotRepository.findAll().size());
    }
    @Test
    public  void should_return_when_delete_parkinglot(){
        ParkingLot parkingLot=new ParkingLot("zhangsan",10,"schools");
        parkingLot=parkingLotRepository.save(parkingLot);
        parkingLotRepository.deleteById(parkingLot.getId());
        assertEquals(1,parkingLotRepository.findAll().size());

    }
    @Test
    public void should_return_pages_when_given_over_pages(){
        for (int i = 0; i <20 ; i++) {
            ParkingLot parkingLot=new ParkingLot("lisi",100,"school");
            parkingLotRepository.save(parkingLot);
        }
        List<ParkingLot>parkingLotList=parkingLotRepository.findAll();
        parkingLotList=parkingLotService.queryParkinglot(1,15);
        assertEquals(15,parkingLotList.size());
    }
    @Test
    public void should_return_name_when_given_name(){
        ParkingLot parkingLotone=new ParkingLot("zhangliu",100,"schools");
        parkingLotRepository.save(parkingLotone);
        ParkingLot parkingLot=parkingLotRepository.findByName(parkingLotone.getName());
        assertThat(100, is(parkingLot.getCapacity()));
    }
    @Test
    public void should_return_update_capacity_when_given_new_capacity(){
        ParkingLot parkingLotone=new ParkingLot("zhangqi",100,"park");
        parkingLotone.setCapacity(parkingLotone.getCapacity()+1);
        parkingLotRepository.save(parkingLotone);

        assertThat(101,is(parkingLotRepository.findByName("zhangqi").getCapacity()));
    }
}
