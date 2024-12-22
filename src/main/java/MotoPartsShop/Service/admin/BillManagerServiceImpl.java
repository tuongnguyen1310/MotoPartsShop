package MotoPartsShop.Service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DAO.BillsDao;
import MotoPartsShop.DTO.BillDetailDto;
import MotoPartsShop.Entity.Bills;

@Service
public class BillManagerServiceImpl implements IBillManagerService{
	@Autowired
	private BillsDao billsDao;

	@Override
	public List<Bills> GetDataBills() {
		List<Bills> list = billsDao.GetDataBills();
		return list;
	}

	public Bills getBillById(int id) {
		return billsDao.GetBillsById(id);
	}

	public void saveBill(Bills billsToEdit) {
		billsDao.saveBill(billsToEdit);
		
	}

	public void deleteBill(int id) {
		billsDao.deleteBill(id);
		
	}

	public List<BillDetailDto> getBillDetailsByBillId(int billId) {
		return billsDao.getBillDetailsByBillId(billId);
	}

}
