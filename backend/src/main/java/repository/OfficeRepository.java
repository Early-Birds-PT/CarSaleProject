package repository;


import data.model.entity.Office;

public interface OfficeRepository {

    Office createOffice(Office office);
    Office readOffice(String officeCode);
    Office updateOffice(Office office);
    boolean deleteOffice(String officeCode);
}
