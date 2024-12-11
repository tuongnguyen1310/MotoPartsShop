package MotoPartsShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DAO.UsersDao;
import MotoPartsShop.Entity.Users;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private UsersDao usersDao;  // Đã sửa: Tiêm phụ thuộc đúng cách

    /**
     * Thêm tài khoản người dùng sau khi thực hiện các kiểm tra hợp lệ.
     */
    public int addAccount(Users user) {
        // Kiểm tra xem tài khoản đã tồn tại chưa
        if (isUsernameExist(user.getUser())) {
            throw new IllegalArgumentException("Tên tài khoản đã tồn tại!");
        }

        // Kiểm tra email có phải là Gmail không
        if (!isValidGmail(user.getUser())) {
            throw new IllegalArgumentException("Email không hợp lệ!");
        }

        // Kiểm tra mật khẩu có đủ mạnh không
        if (!isPasswordStrong(user.getPassword())) {
            throw new IllegalArgumentException("Mật khẩu phải có ít nhất 8 ký tự và bao gồm cả chữ cái và số!");
        }

       

        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));

        // Thêm tài khoản mới vào cơ sở dữ liệu
        return usersDao.AddAccount(user);
    }

    /**
     * Kiểm tra xem username đã tồn tại trong cơ sở dữ liệu chưa.
     */
    public boolean isUsernameExist(String username) {
        return usersDao.isUsernameExist(username);
    }

    /**
     * Kiểm tra định dạng email có phải là Gmail không.
     */
    private boolean isValidGmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
        return email.matches(regex);
    }

    /**
     * Kiểm tra mật khẩu có đủ mạnh không.
     */
    private boolean isPasswordStrong(String password) {
        // Mật khẩu phải có ít nhất 8 ký tự, bao gồm chữ cái và số
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        return password.matches(regex);
    }

    
	public Users checkAccount(Users user) {
		String password = user.getPassword();
		user = usersDao.GetUserByAccount(user);
		if (user != null) {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return user;
			}
			else {
				return null;
			}
		}
		return null;
	}


}
