package service.impl;

import data.model.entity.Office;
import repository.OfficeRepository;
import repository.repository_impl.OfficeRepositoryImpl;
import service.OfficeService;

public class OfficeServiceImpl implements OfficeService {

    private OfficeRepository officeRepository = new OfficeRepositoryImpl();

    @Override
    public Office createOffice(Office office) {
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
    public void deleteOffice(String officeCode) {
        officeRepository.deleteOffice(officeCode);
    }
}


