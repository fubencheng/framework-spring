package com.net.lnk.spring.jdbc.service;

import java.util.List;

import com.net.lnk.spring.jdbc.IdCardEntity;

/**
 * @author Ben
 * @memo 2017年4月12日
 */
public interface IdCardService {

	IdCardEntity getIdCard(long id);

	List<IdCardEntity> getIdCards(List<Long> ids);

}
