package repository;


import data.model.entity.Office;

public interface OfficeRepository {

    Office createOffice(Office office);
    Office readOffice(String officeCode);
    void updateOffice(Office office);
    void deleteOffice(String officeCode);
}
