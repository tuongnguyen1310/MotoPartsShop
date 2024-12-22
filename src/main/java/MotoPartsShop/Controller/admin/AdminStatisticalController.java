package MotoPartsShop.Controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	    if (statistics == null || statistics.isEmpty()) {
	        model.addAttribute("errorMessage", "Không có dữ liệu thống kê.");
	    }
	    System.out.println(statistics);
	    model.addAttribute("statistics", statistics);
	    return "admin/statistical/statistical_manager";
	}

}
