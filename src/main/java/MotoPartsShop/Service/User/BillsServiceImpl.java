package MotoPartsShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DAO.BillsDao;
import MotoPartsShop.DTO.CartDto;
import MotoPartsShop.Entity.BillDetail;
import MotoPartsShop.Entity.Bills;

@Service
public class BillsServiceImpl implements IBillsService{
	@Autowired
	BillsDao billsDao = new BillsDao();
	
	public int Addbills(Bills bill) {
		return billsDao.addBills(bill);
		
	}

	@Override
	public void AddBillsDetail(HashMap<Integer, CartDto> carts) {
		int idBills = billsDao.getIDLastBills();
		
		for(Map.Entry<Integer, CartDto> itemCart : carts.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bills(idBills);
			billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDao.addBillsDetail(billDetail);
		}
		
	}
}
