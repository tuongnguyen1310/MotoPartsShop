package MotoPartsShop.Controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import MotoPartsShop.Controller.user.BaseController;
import MotoPartsShop.DTO.BillDetailDto;
import MotoPartsShop.Entity.Bills;
import MotoPartsShop.Service.admin.BillManagerServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminBillController extends BaseController {
	@Autowired
	private BillManagerServiceImpl billManagerServiceImpl;

	@RequestMapping(value = { "/don-hang" })
	public ModelAndView showDashboard(HttpSession session) {
		_mvShare.addObject("bills", billManagerServiceImpl.GetDataBills());

		_mvShare.setViewName("admin/bills/billmanager");
		return _mvShare;
	}

	@RequestMapping(value = "/don-hang/editBill", method = RequestMethod.POST)
	public String editBill(@RequestParam("id") int id, @RequestParam("user") String user,
			@RequestParam("phone") String phone, @RequestParam("display_name") String displayName,
			@RequestParam("address") String address, @RequestParam("total") Double total,
			@RequestParam("quanty") int quanty, @RequestParam("note") String note) {
		// Tìm người dùng theo ID
		Bills billsToEdit = billManagerServiceImpl.getBillById(id);

		// Cập nhật thông tin người dùng
		if (billsToEdit != null) {
			billsToEdit.setUser(user);
			billsToEdit.setPhone(phone);
			billsToEdit.setDisplay_name(displayName);
			billsToEdit.setAddress(address);
			billsToEdit.setTotal(total);
			billsToEdit.setQuanty(quanty);
			billsToEdit.setNote(note);

			// Lưu thông tin người dùng đã chỉnh sửa
			billManagerServiceImpl.saveBill(billsToEdit);
		}

		// Chuyển hướng về trang quản lý người dùng
		return "redirect:/admin/don-hang";
	}

	@RequestMapping(value = "/don-hang/deleteBill", method = RequestMethod.POST)
	public String deleteBill(@RequestParam("id") int id) {
		// Xóa người dùng khỏi cơ sở dữ liệu
		billManagerServiceImpl.deleteBill(id);

		// Chuyển hướng lại trang quản lý người dùng
		return "redirect:/admin/don-hang";
	}

	@RequestMapping(value = "/don-hang/chi-tiet/{id}", method = RequestMethod.GET)
	public ModelAndView showBillDetails(@PathVariable("id") int billId) {
		List<BillDetailDto> billDetails = billManagerServiceImpl.getBillDetailsByBillId(billId);

	    // Tính tổng số lượng và tổng tiền
	    int totalQuantity = billDetails.stream().mapToInt(BillDetailDto::getQuanty).sum();
	    double totalAmount = billDetails.stream().mapToDouble(BillDetailDto::getTotal).sum();
		
		// Lấy danh sách chi tiết hóa đơn từ service
		_mvShare.addObject("billDetails", billManagerServiceImpl.getBillDetailsByBillId(billId));
		_mvShare.addObject("billId", billId);
		_mvShare.addObject("totalQuantity", totalQuantity);
	    _mvShare.addObject("totalAmount", totalAmount);


		// Trả về view hiển thị chi tiết hóa đơn
		_mvShare.setViewName("admin/bills/billdetails");
		return _mvShare;
	}

}
