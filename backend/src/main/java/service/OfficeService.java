package service;

import data.model.entity.Office;

public interface OfficeService {

    Office createOffice(Office office, String officeCode);
    Office readOffice(String officeCode);
    void updateOffice(Office office);
    void deleteOffice(Office office, String officeCode);

}
