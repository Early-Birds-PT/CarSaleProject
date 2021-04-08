package service;

import model.entity.Office;

public interface OfficeService {

    Office createOffice(Office office);
    Office readOffice(String officeCode);
    Office updateOffice(Office office);
    boolean deleteOffice(String officeCode);
}
