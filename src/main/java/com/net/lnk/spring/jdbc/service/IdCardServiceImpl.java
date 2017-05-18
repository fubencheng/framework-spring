package com.net.lnk.spring.jdbc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.net.lnk.spring.jdbc.IdCardEntity;

/**
 * @author Ben
 * @memo 2017年4月12日
 */
@Service("idCardService")
public class IdCardServiceImpl implements IdCardService {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public IdCardEntity getIdCard(long id) {
		String sql = "select id, member_no, name, idno, gender, idAddr from t_client_certification where id = ?";

		RowMapper<IdCardEntity> rowMapper = new BeanPropertyRowMapper<IdCardEntity>(IdCardEntity.class);

		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	public List<IdCardEntity> getIdCards(List<Long> ids) {
		String sql = "select id, member_no, name, idno, gender, idAddr from t_client_certification where id in ( :ids )";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ids", ids);

		List<Map<String, Object>> idCardMapList = namedParameterJdbcTemplate.queryForList(sql, paramMap);

		List<IdCardEntity> idCards = new ArrayList<IdCardEntity>();
		for (Map<String, Object> map : idCardMapList) {
			IdCardEntity idCard = new IdCardEntity();
			idCard.setId((Long) map.get("id"));
			idCard.setMemberNo((String) map.get("member_no"));
			idCard.setName((String) map.get("name"));
			idCard.setIdNo((String) map.get("idno"));
			idCard.setGender((Integer) map.get("gender"));
			idCard.setIdAddr((String) map.get("idAddr"));
			idCards.add(idCard);
		}

		return idCards;
	}

}
