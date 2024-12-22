package MotoPartsShop.Service.admin;

import java.util.List;

import MotoPartsShop.DTO.BillStatisticsDto;

public interface IBillRepository {
    List<BillStatisticsDto> getMonthlyStatistics();
}