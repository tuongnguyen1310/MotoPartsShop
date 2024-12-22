package MotoPartsShop.Service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DTO.BillStatisticsDto;

@Service
public class AdminBillServiceImpl implements IAdminBillService {
	@Autowired
    private BillRepositoryImpl billRepositoryImpl;

	@Override
	public List<BillStatisticsDto> getMonthlyStatistics() {
	    List<BillStatisticsDto> statistics = billRepositoryImpl.getMonthlyStatistics();
	    if (statistics == null) {
	        return new ArrayList<>(); // Trả về danh sách rỗng thay vì null
	    }
	    System.out.println(statistics);
	    return statistics;
	}

}	
