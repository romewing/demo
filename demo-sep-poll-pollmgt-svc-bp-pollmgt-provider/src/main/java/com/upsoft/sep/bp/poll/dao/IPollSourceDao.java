package com.upsoft.sep.bp.poll.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.upsoft.sep.bp.common.entity.RequestPage;
import com.upsoft.sep.bp.poll.IBpPollSourceMarker;
import com.upsoft.sep.bp.poll.entity.PollSource;

public interface IPollSourceDao extends IBpPollSourceMarker{

	/**
	 *根据id查询污染源
	 */
	public PollSource getPollSourceById(@Param("id") String id);
	
	
	
	/**
	 * 根据id删除污染源
	 * @return
	 */
	public void delPollSourceById(@Param("id") String id);
	
	
	/**
	 * 根据id修改数据
	 * @param pollSource
	 */
	public void  updatePollSourceById(PollSource pollSource);


//	/**
//	 * 分页查询
//	 * @param page
//	 * @param pageSize
//	 */
//	public List queryPollSourcePage(Integer page, Integer pageSize);



	public List<PollSource> queryPollSourcePage(RequestPage s);



	public void inertPollSource(PollSource pollSource);
	
}
