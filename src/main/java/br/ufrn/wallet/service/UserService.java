package br.ufrn.wallet.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User createUser(User user);
    public void deleteUser(User user);
    public User getUserById(Integer id);
    
}