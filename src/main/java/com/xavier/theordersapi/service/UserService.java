package com.xavier.theordersapi.service;

import com.xavier.theordersapi.model.UserAccount;
import com.xavier.theordersapi.repository.UserRepository;
import com.xavier.theordersapi.service.exception.UserFoundException;
import com.xavier.theordersapi.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserAccount> findAll() {
        return userRepository.findAll();
    }

    public UserAccount findById(Long id) {
        verifyIfNotExistsUserWithGivenId(id);
        return userRepository.getOne(id);
    }

    private void verifyIfNotExistsUserWithGivenId(Long id) {
        Optional<UserAccount> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty()) {
            throw new UserNotFoundException();
        }
    }

    public UserAccount save(final UserAccount userAccount) {
        verifyIfUserWithGivenEmailExists(userAccount);
        return userRepository.save(userAccount);
    }

    public void delete(Long id) {
       verifyIfNotExistsUserWithGivenId(id);
       userRepository.deleteById(id);
    }


    private void verifyIfUserWithGivenEmailExists(UserAccount userAccount) {
        Optional<UserAccount> foundUser = userRepository.findByEmail(userAccount.getEmail());
        if (foundUser.isPresent() && (userAccount.isNew() || isUpdatingToADifferentUser(userAccount, foundUser))) {
            throw new UserFoundException();
        }
    }

    private boolean isUpdatingToADifferentUser(UserAccount userAccount, Optional<UserAccount> foundUser) {
        return userAccount.exist() && !userAccount.equals(foundUser);
    }
}
