package com.bilgeadam.springbootteknikservis.service;

import com.bilgeadam.springbootteknikservis.repo.ServiceRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicesService
{
    private ServiceRepo serviceRepo;

    public List<com.bilgeadam.springbootteknikservis.model.Service> getAll()
    {
        return serviceRepo.findAll();
    }
    public com.bilgeadam.springbootteknikservis.model.Service getByID(long id)
    {
        return serviceRepo.findById(id).get();
    }


}
