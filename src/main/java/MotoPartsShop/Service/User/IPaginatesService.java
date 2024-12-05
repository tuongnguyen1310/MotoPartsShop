package MotoPartsShop.Service.User;

import org.springframework.stereotype.Service;

import MotoPartsShop.DTO.PaginatesDto;

@Service
public interface IPaginatesService {
	public PaginatesDto getInfoPaginates(Integer totalPage, Integer limit, Integer currentPage);
}
