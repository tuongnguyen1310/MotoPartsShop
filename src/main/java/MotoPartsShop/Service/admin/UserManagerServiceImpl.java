package MotoPartsShop.Service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DAO.UsersDao;
import MotoPartsShop.Entity.Users;

@Service
public class UserManagerServiceImpl implements IUserManagerService {
	@Autowired
    private UsersDao userDao; // Giả sử bạn đã tạo lớp UserDao để thao tác với database

    public List<Users> getAllUsers() {
        return userDao.getDataAllUser();
    }
}
