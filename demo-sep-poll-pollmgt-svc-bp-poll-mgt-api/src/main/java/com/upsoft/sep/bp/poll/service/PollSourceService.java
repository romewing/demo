/*
 * Copyright (c) 2014-2018 Upsoft Co.Ltd. All rights reserved.
 */

package com.upsoft.sep.bp.poll.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.upsoft.sep.bp.common.entity.RequestPage;
import com.upsoft.sep.bp.common.entity.ResponsePage;
import com.upsoft.sep.bp.common.entity.Result;
import com.upsoft.sep.bp.common.util.GlobalRestApiAction;
import com.upsoft.sep.bp.poll.entity.PollSource;
import com.upsoft.sep.bp.poll.param.PollIdParam;
import com.upsoft.sep.bp.poll.param.PollSelectParam;

/**
 * 
 * 污染源管理接口定义
 * 
 * @author tanbin
 */
@Path("/pollmgt/poll/")
@Consumes(ContentType.APPLICATION_JSON_UTF_8)
public interface PollSourceService {

	public static final String TAG = "/pollmgt/poll(污染源信息) api注释参见此方法";

	@Path(GlobalRestApiAction.GET)
	@POST
	@Produces({ "application/json; charset=UTF-8" })
	@ApiOperation(hidden = false, value = "根据id查询数据源", notes = "参数{id:\"1\"}", tags = TAG)
	public Result<PollSource> queryById(PollIdParam id);

	@Path(GlobalRestApiAction.PAGE)
	@POST
	@ApiParam(example = "{id:'1'}")
	@Produces({ "application/json; charset=UTF-8" })
	@ApiResponse(response = ResponsePage.class, code = 0, message = "")
	@ApiOperation(hidden = false, value = "分页查询数据源", notes = "", tags = TAG)
	public Result<ResponsePage<List<PollSource>>> queryPollSourcePage(RequestPage<PollSelectParam> page);

	@ApiOperation(hidden = false, value = "根据id删除数据源", notes = "参数{id:\"1\"}", tags = TAG)
	@Path(GlobalRestApiAction.DEL)
	@POST
	@Produces({ "application/json; charset=UTF-8" })
	public Result<String> delPollSourceById(PollIdParam id);

	@ApiOperation(value = "根据id修改数据源", hidden = false, notes = "", tags = TAG)
	@Path(GlobalRestApiAction.MOD)
	@POST
	@Produces({ "application/json; charset=UTF-8" })
	public Result<String> updatePollSourceById(PollSource pollSource);

	@ApiOperation(value = "添加数据源", hidden = false, notes = "", tags = TAG)
	@Path(GlobalRestApiAction.ADD)
	@POST
	@Produces({ "application/json; charset=UTF-8" })
	public Result<String> addPollSource(PollSource pollSource);

}
