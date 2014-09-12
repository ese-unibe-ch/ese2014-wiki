package org.sample.service;

import org.sample.dao.AddressDao;
import org.sample.dao.UserDao;
import org.sample.dao.model.Address;
import org.sample.dao.model.User;
import org.sample.exception.InvalidUserException;
import org.sample.model.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }

        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        
        Address add = new Address();
        add.setStreet("TestStreet");
        add.setUser(user);
        
        user = userDao.save(user);   // save object to DB
        add = addDao.save(add);  
        
        
        Iterable<Address> addresses = addDao.findAll();  // find all 
        Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getId());

        return signupForm;

    }
}
