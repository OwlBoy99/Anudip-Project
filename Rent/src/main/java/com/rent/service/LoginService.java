package com.rent.service;

import com.rent.model.User;

public interface LoginService {
	boolean authenticate(User user);
}
