package MotoPartsShop.Service.User;

import org.springframework.stereotype.Service;

import MotoPartsShop.DTO.PaginatesDto;

@Service
public class PaginateServiceImpl implements IPaginatesService{
	public PaginatesDto getInfoPaginates(Integer totalData, Integer limit, Integer currentPage) {
		PaginatesDto paginatesDto = new PaginatesDto();
		paginatesDto.setLimit(limit);
		paginatesDto.setTotalPage(setInfoTotalPage(totalData, limit));
		paginatesDto.setCurrentPage(checkCurrentPage(currentPage, setInfoTotalPage(totalData, limit)));
		
		int start = findStart(paginatesDto.getCurrentPage(), limit);
		paginatesDto.setStart(start);
		
		int end = findEnd(totalData, limit, start);
		paginatesDto.setEnd(end);
		
		
		return paginatesDto;
	}

	private int findStart(int currentPage, Integer limit) {
		
		return ((currentPage - 1) * limit) + 1;
	}
	
	private int findEnd(int totalData, int limit, int start) {
		return start + limit > totalData ? totalData : (start + limit) - 1;
	}
	
	private int setInfoTotalPage(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData / limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}
	
	private int checkCurrentPage(int currentPage, int totalPage) {
		if(currentPage < 1) {
			return 1;
		}
		if(currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}
}
