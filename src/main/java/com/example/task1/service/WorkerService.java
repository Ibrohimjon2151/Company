package com.example.task1.service;

import com.example.task1.entity.Address;
import com.example.task1.entity.Department;
import com.example.task1.entity.Worker;
import com.example.task1.entity.abstractClass.ApiResponse;
import com.example.task1.peliod.AddressDTO;
import com.example.task1.peliod.WorkerDTO;
import com.example.task1.repository.AddressRepository;
import com.example.task1.repository.DepartmentRepository;
import com.example.task1.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository addressRepository;

    @Autowired
    AddressRepository addressRepository2;

    @Autowired
    DepartmentRepository departmentRepository;

    public ApiResponse addAddress(WorkerDTO address){
        Worker address1 = new Worker();
        address1.setAllName(address.getName());

        Optional<Address> optionalWorker = addressRepository2.findById(address.getAddressId());
        Optional<Department> department = departmentRepository.findById(address.getDepartmrntId());

        address1.setAddress(optionalWorker.get());

        address1.setDepartment(department.get());
        address1.setPhoneNummber(address.getPhoneNummber());
        addressRepository.save(address1);
        return new ApiResponse(true , address1);
    }

    public List<Worker> getAll(){
        List<Worker> all = addressRepository.findAll();
        return all;
    }

    public ApiResponse getOne( int id){
        Optional<Worker> optionalAddress = addressRepository.findById(id);
        return optionalAddress.map(address -> new ApiResponse(true, address)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));
    }

    public ApiResponse edite( int id , WorkerDTO addressDTO){
        Optional<Worker> optionalAddress = addressRepository.findById(id);
        Worker address = optionalAddress.get();
        address.setPhoneNummber(addressDTO.getPhoneNummber());
        address.setAllName(addressDTO.getName());
        Optional<Address> optionalWorker = addressRepository2.findById(addressDTO.getAddressId());
        Optional<Department> department = departmentRepository.findById(addressDTO.getDepartmrntId());

        address.setAddress(optionalWorker.get());
        address.setDepartment(department.get());
        addressRepository.save(address);
        return optionalAddress.map(value -> new ApiResponse(true, value)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));
    }

    public ApiResponse delete(int id){
        Optional<Worker> optionalAddress = addressRepository.findById(id);
        addressRepository.deleteById(id);
        return optionalAddress.map(address -> new ApiResponse(true, address)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));

    }





}
