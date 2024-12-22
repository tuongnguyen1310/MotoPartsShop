package MotoPartsShop.Controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import MotoPartsShop.DTO.BillStatisticsDto;
import MotoPartsShop.Service.admin.AdminBillServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminStatisticalController extends BaseAdminController{
	
	@Autowired
	private AdminBillServiceImpl adminBillServiceImpl;
	
	@RequestMapping("/thong-ke")
	public String getStatisticsPage(Model model) {
	    List<BillStatisticsDto> statistics = adminBillServiceImpl.getMonthlyStatistics();
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        String statisticsJson = mapper.writeValueAsString(statistics);
	        model.addAttribute("statisticsJson", statisticsJson); // Chuỗi JSON để dùng cho JavaScript
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    model.addAttribute("statistics", statistics); // Dữ liệu thô để hiển thị bảng
	    return "admin/statistical/statistical_manager";
	}





}
