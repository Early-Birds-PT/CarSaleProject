package service.impl;

import data.model.entity.Employee;
import data.model.entity.Office;
import repository.OfficeRepository;
import repository.repository_impl.OfficeRepositoryImpl;
import service.OfficeService;

import java.util.Random;

public class OfficeServiceImpl implements OfficeService {

    private OfficeRepository officeRepository = new OfficeRepositoryImpl();

    @Override
    public Office createOffice(Office office) {
        office.setOfficeCode(String.valueOf(generateUniqueID()));
        return officeRepository.createOffice(office);
    }

    @Override
    public Office readOffice(String officeCode) {
        return officeRepository.readOffice(officeCode);
    }

    @Override
    public Office updateOffice(Office office) {
        return officeRepository.updateOffice(office);
    }

    @Override
    public boolean deleteOffice(String officeCode) {
        return officeRepository.deleteOffice(officeCode);
    }

    private int generateUniqueID() {
        int number = 0;
        do{
            number = new Random().nextInt(100000000);
        } while(officeRepository.readOffice(String.valueOf(number)) != null);
        return number;
    }
}


