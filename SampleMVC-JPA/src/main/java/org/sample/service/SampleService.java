package org.sample.service;

import org.sample.exception.InvalidUserException;
import org.sample.model.SignupForm;

public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

}
