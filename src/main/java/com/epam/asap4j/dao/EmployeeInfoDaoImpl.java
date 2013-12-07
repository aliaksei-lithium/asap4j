package com.epam.asap4j.dao;

import com.epam.asap4j.dto.EmployeeInfo;
import com.epam.asap4j.dto.Feature;
import org.springframework.stereotype.Repository;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
@Repository
public class EmployeeInfoDaoImpl extends BaseDaoImpl<EmployeeInfo, String> implements EmployeeInfoDao {

    public EmployeeInfoDaoImpl() {
        super(EmployeeInfo.class);
    }
}
