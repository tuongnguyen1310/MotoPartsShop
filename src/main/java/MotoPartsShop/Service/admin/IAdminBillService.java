package MotoPartsShop.Service.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import MotoPartsShop.DTO.BillStatisticsDto;
@Service
public interface IAdminBillService {
	List<BillStatisticsDto> getMonthlyStatistics();
}
