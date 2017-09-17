package com.upsoft.sep.bp.poll.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upsoft.sep.bp.common.entity.RequestPage;
import com.upsoft.sep.bp.common.entity.ResponsePage;
import com.upsoft.sep.bp.common.entity.Result;
import com.upsoft.sep.bp.common.util.StringUtil;
import com.upsoft.sep.bp.poll.dao.IPollSourceDao;
import com.upsoft.sep.bp.poll.entity.PollSource;
import com.upsoft.sep.bp.poll.param.PollIdParam;
import com.upsoft.sep.bp.poll.param.PollSelectParam;
import com.upsoft.sep.bp.sso.client.bean.User;
import com.upsoft.sep.bp.sso.client.utils.UserUtil;
import com.upsoft.sep.bp.user.param.UserGetParam;
import com.upsoft.sep.bp.user.service.UserService;


/**
 * 
 * @author tanbin
 *
 */
@Service
public class PollSourceServiceImpl implements PollSourceService{

	@Autowired
	private IPollSourceDao pollSourceDao;
	@Autowired
	private UserService  uService;
	
	@Override
	public Result<PollSource> queryById(PollIdParam id) {
//		PollSource ps=pollSourceDao.getPollSourceById(param.get("id"));
		PollSource ps=pollSourceDao.getPollSourceById(id.getId());
		Result r=new Result();
		r.setStatus(Result.STATUS_SUCCES);
		r.setData(ps);
		return r;
	}

	@Override
	public Result<String> delPollSourceById(PollIdParam id) {
//		pollSourceDao.delPollSourceById(map.get("id"));
		pollSourceDao.delPollSourceById(id.getId());
		Result r=new Result();
		r.setStatus(Result.STATUS_SUCCES);
		r.setMsg("删除成功！");
		return r;
	}

	@Override
	public Result<String> updatePollSourceById(PollSource pollSource) {
		pollSourceDao.updatePollSourceById(pollSource);
		Result r=new Result();
		r.setStatus(Result.STATUS_SUCCES);
		r.setMsg("更新成功！");
		return r;
	}

//	@Override
//	public Result queryPollSourcePage(String key) {
//		Map<String, String> map=StringUtil.getParaCollection(key, "&", "=");
//		RequestPage p=RequestPage.getPageByMap(map);
//		p.putParam("orgCode", map.get("orgCode"));
//		List<PollSource> o=pollSourceDao.queryPollSourcePage(p);
//		ResponsePage rPage=new ResponsePage();
//		rPage.setData(o);
//		
//		Result r=new Result();
//		r.setData(rPage);
//		r.setStatus(Result.STATUS_SUCCES);
//		return r;
//	}
	
	
	@Override
	public Result<ResponsePage<List<PollSource>>> queryPollSourcePage(RequestPage<PollSelectParam> page) {
//		Map<String, String> map=StringUtil.getParaCollection(key, "&", "=");
//		RequestPage p=RequestPage.getPageByMap(map);
//		p.putParam("orgCode", map.get("orgCode"));
		User u=UserUtil.getCurrentUser();
		System.out.println(u);
		UserGetParam up=new UserGetParam();
		up.setUserId(u.getUserId());
		Result<com.upsoft.sep.bp.user.entity.User> user=uService.get(up);
		System.out.println(user.getData().getUserName());
		List<PollSource> o=pollSourceDao.queryPollSourcePage(page);
		ResponsePage rPage=page.toResponsePage();
		rPage.setData(o);
		
		Result r=new Result();
		r.setData(rPage);
		r.setStatus(Result.STATUS_SUCCES);
		return r;
	}
	

	@Override
	public Result addPollSource(PollSource pollSource) {
		pollSource.setId(StringUtil.uuid());
		pollSource.setCreateTime(new Date());
		pollSourceDao.inertPollSource(pollSource);
		Result r=new Result();
		r.setStatus(Result.STATUS_SUCCES);
		r.setMsg("添加成功！");
		return r;
	}

	

	
	
}
