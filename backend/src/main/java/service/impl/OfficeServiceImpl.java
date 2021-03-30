package service.impl;

import data.model.entity.Office;
import repository.OfficeRepository;
import repository.repository_impl.OfficeRepositoryImpl;
import service.OfficeService;

public class OfficeServiceImpl implements OfficeService {

    private OfficeRepository officeRepository = new OfficeRepositoryImpl();

    @Override
    public Office createOffice(Office office, String officeCode) {
        return officeRepository.createOffice(office, officeCode);
    }

    @Override
    public Office readOffice(String officeCode) {
        return officeRepository.readOffice(officeCode);
    }

    @Override
    public void updateOffice(Office office) {
        officeRepository.updateOffice(office);
    }

    @Override
    public void deleteOffice(String officeCode) {
        officeRepository.deleteOffice(officeCode);
    }
}


