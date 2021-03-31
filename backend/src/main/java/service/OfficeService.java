package service;

import data.model.entity.Office;

public interface OfficeService {

    Office createOffice(Office office);
    Office readOffice(String officeCode);
    Office updateOffice(Office office);
    void deleteOffice(String officeCode);

}
