package repository;


import data.model.entity.Employee;
import data.model.entity.Office;

import java.util.List;

public interface OfficeRepository {

    Office createOffice(Office office);
    Office readOffice(String officeCode);
    Office updateOffice(Office office);
    boolean deleteOffice(String officeCode);
}
