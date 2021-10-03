package com.example.task1.service;

import com.example.task1.entity.Address;
import com.example.task1.entity.abstractClass.ApiResponse;
import com.example.task1.peliod.AddressDTO;
import com.example.task1.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    public ApiResponse addAddress(AddressDTO address){
        Address address1 = new Address();

        address1.setHomeNummber(address.getHomeNummber());
        address1.setAllName(address.getName());

        addressRepository.save(address1);
        return new ApiResponse(true , address1);
    }

    public List<Address> getAll(){
        List<Address> all = addressRepository.findAll();
        return all;
    }

    public ApiResponse getOne( int id){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        return optionalAddress.map(address -> new ApiResponse(true, address)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));
    }

    public ApiResponse edite( int id , AddressDTO addressDTO){
        Optional<Address> optionalAddress = addressRepository.findById(id);

        Address address = optionalAddress.get();
        address.setHomeNummber(addressDTO.getHomeNummber());
        address.setAllName(addressDTO.getName());
        addressRepository.save(address);
        return optionalAddress.map(value -> new ApiResponse(true, value)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));
    }

    public ApiResponse delete(int id){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        addressRepository.deleteById(id);
        return optionalAddress.map(address -> new ApiResponse(true, address)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));

    }





}
