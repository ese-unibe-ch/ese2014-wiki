package org.sample.dao;

import org.sample.dao.model.Address;
import org.springframework.data.repository.CrudRepository;


public interface AddressDao  extends CrudRepository<Address,Long>{

}
