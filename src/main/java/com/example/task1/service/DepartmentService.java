package com.example.task1.service;

import com.example.task1.entity.Address;
import com.example.task1.entity.Company;
import com.example.task1.entity.Department;
import com.example.task1.entity.abstractClass.ApiResponse;
import com.example.task1.peliod.AddressDTO;
import com.example.task1.peliod.DepartmentDTO;
import com.example.task1.repository.AddressRepository;
import com.example.task1.repository.CompanyRepository;
import com.example.task1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository addressRepository;

    @Autowired
    CompanyRepository companyRepository;

    public ApiResponse addAddress(DepartmentDTO address){
        Department address1 = new Department();

        address1.setAllName(address.getName());

        Optional<Company> company = companyRepository.findById(address.getCompanyId());

        address1.setCompany(company.get());


        addressRepository.save(address1);
        return new ApiResponse(true , address1);
    }

    public List<Department> getAll(){
        List<Department> all = addressRepository.findAll();
        return all;
    }

    public ApiResponse getOne( int id){
        Optional<Department> optionalAddress = addressRepository.findById(id);
        return optionalAddress.map(address -> new ApiResponse(true, address)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));
    }

    public ApiResponse edite( int id , DepartmentDTO addressDTO){
        Optional<Department> optionalAddress = addressRepository.findById(id);

        Department address = optionalAddress.get();
        address.setAllName(addressDTO.getName());

        Optional<Company> company = companyRepository.findById(addressDTO.getCompanyId());

        address.setCompany(company.get());

        addressRepository.save(address);
        return company.map(value -> new ApiResponse(true, value)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));
    }

    public ApiResponse delete(int id){
        Optional<Department> optionalAddress = addressRepository.findById(id);
        addressRepository.deleteById(id);
        return optionalAddress.map(address -> new ApiResponse(true, address)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));

    }





}
