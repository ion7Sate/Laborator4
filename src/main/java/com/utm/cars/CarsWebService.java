package com.utm.cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cars/")
public class CarsWebService {
    @Autowired
    CarsRepository carsRepository;

    @GetMapping("car")
    public List<Cars>  findAll(){
        return carsRepository.findAll();
    }

    @PostMapping("car")
    public void save(@RequestBody Cars car) {
        carsRepository.save(car);

    }

    @DeleteMapping("car/{brand}")
    public void delete(@PathVariable String brand){
         carsRepository.delete(brand);
    }



}
