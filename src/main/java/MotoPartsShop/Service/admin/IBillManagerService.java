package MotoPartsShop.Service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.Entity.Bills;

@Service
public interface IBillManagerService {
	@Autowired
	public List<Bills> GetDataBills();
	public Bills getBillById(int id);
}
