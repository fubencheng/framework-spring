package com.net.lnk.spring.jdbc.service;

import java.util.List;

/**
 * @author Ben
 * @memo 2017年4月12日
 */
public interface AsynHandler {

	void asynHandleIdCardQuery(List<Long> ids);

}
