package com.example.mongoservice.service.transfersDb;

import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.transfersDb.Transfers;
import com.example.mongoservice.repository.transfersDb.ITransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransfersServiceImpl implements ITransfersService{
    @Autowired
    private ITransfersRepository transfersRepo;
    @Override
    public List<Transfers> getAllTransfers() {
        return transfersRepo.findAll();
    }

    @Override
    public Transfers getTransfersById(long empId) throws EmployeeNotFoundException {
        Optional<Transfers> tempTransfers=transfersRepo.findById(empId);
        if(tempTransfers.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the given id:"+empId+" does not exist");
        }
        return tempTransfers.get();
    }

    @Override
    public Transfers deleteTransfersById(long empId) throws EmployeeNotFoundException {
        Optional<Transfers> tempTransfers=transfersRepo.findById(empId);
        if(tempTransfers.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the given id:"+empId+" does not exist");
        }
        transfersRepo.deleteById(empId);
        return tempTransfers.get();
    }

    @Override
    public Transfers addTransfers(Transfers transfers) throws EmployeeFoundException{
        long empId=transfers.getEmployeeId();
        Optional<Transfers> temptransfers=transfersRepo.findById(empId);
        if(temptransfers.isPresent()) {
            throw new EmployeeFoundException("Employee with the given id:" + empId + " already exists");
        }
        return transfersRepo.save(transfers);
    }

    @Override
    public Transfers updateTransfers(Transfers transfers) throws EmployeeNotFoundException{
        long empId=transfers.getEmployeeId();
        Optional<Transfers> temptransfers=transfersRepo.findById(empId);
        if(temptransfers.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with the given id:" + empId + " does not exist");
        }
        return transfersRepo.save(transfers);
    }
}
