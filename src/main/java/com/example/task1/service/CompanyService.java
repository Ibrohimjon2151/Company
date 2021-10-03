package com.example.task1.service;

import com.example.task1.entity.Address;
import com.example.task1.entity.Company;
import com.example.task1.entity.abstractClass.ApiResponse;
import com.example.task1.peliod.AddressDTO;
import com.example.task1.peliod.CompanyDTO;
import com.example.task1.repository.AddressRepository;
import com.example.task1.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CompanyRepository companyRepository;

    public ApiResponse addAddress(CompanyDTO address){
        Optional<Address> optionalAddress = addressRepository.findById(address.getAddressId());

        Company company = new Company();

        company.setAddress(optionalAddress.get());
        company.setAllName(address.getName());
        company.setDirektoName(address.getDirektorName());
        companyRepository.save(company);

        return new ApiResponse(true , company);
    }

    public List<Company> getAll(){
        List<Company> all = companyRepository.findAll();
        return all;
    }

    public ApiResponse getOne( int id){
        Optional<Company> optionalAddress = companyRepository.findById(id);
        return optionalAddress.map(address -> new ApiResponse(true, address)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));
    }

    public ApiResponse edite( int id , CompanyDTO addressDTO){
        Optional<Company> optionalAddress2 = companyRepository.findById(id);
        Optional<Address> optionalAddress = addressRepository.findById(addressDTO.getAddressId());

        Company company = optionalAddress2.get();
        company.setAddress(optionalAddress.get());
        company.setAllName(addressDTO.getName());
        company.setDirektoName(addressDTO.getDirektorName());
        companyRepository.save(company);
        return optionalAddress2.map(value -> new ApiResponse(true, value)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));
    }

    public ApiResponse delete(int id){
        Optional<Company> optionalAddress = companyRepository.findById(id);
        companyRepository.deleteById(id);
        return optionalAddress.map(address -> new ApiResponse(true, address)).orElseGet(() -> new ApiResponse(false, "NOT FUND"));

    }





}
