package com.example.task1.controller;

import com.example.task1.entity.Address;
import com.example.task1.entity.abstractClass.ApiResponse;
import com.example.task1.peliod.AddressDTO;
import com.example.task1.peliod.CompanyDTO;
import com.example.task1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping
    public HttpEntity<ApiResponse> add(@RequestBody AddressDTO address){
        ApiResponse apiResponse = addressService.addAddress(address);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<List<Address>> getAll(){
        List<Address> addressServiceAll = addressService.getAll();
        return ResponseEntity.ok(addressServiceAll);
    }

    @GetMapping ("/{id}")
    public HttpEntity<ApiResponse> getOne(@PathVariable int id){
        ApiResponse addressServiceOne = addressService.getOne(id);
        return ResponseEntity.status(addressServiceOne.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(addressServiceOne);

    }

    @PutMapping("/{id}")
    public HttpEntity<ApiResponse> edited(@PathVariable int id , @RequestBody AddressDTO addressDTO){
        ApiResponse addressServiceOne = addressService.edite(id , addressDTO);
        return ResponseEntity.status(addressServiceOne.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(addressServiceOne);

    }

    @DeleteMapping("/{id}")
    public HttpEntity<ApiResponse> deleteById(@PathVariable int id){
        ApiResponse delete = addressService.delete(id);
        return ResponseEntity.ok(delete);
    }

}
