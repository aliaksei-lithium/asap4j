package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Feature;
import com.epam.asap4j.dto.Group;
import org.springframework.stereotype.Repository;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
@Repository
public class FeatureDaoImpl extends BaseDaoImpl<Feature> implements FeatureDao {

    public FeatureDaoImpl() {
        super(Feature.class);
    }
}
