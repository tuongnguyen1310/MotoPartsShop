package MotoPartsShop.Service.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import MotoPartsShop.Entity.Users;

@Service
public interface IUserManagerService {
	public List<Users> getAllUsers();
}
	