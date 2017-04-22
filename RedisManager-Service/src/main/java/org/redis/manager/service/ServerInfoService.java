package org.redis.manager.service;

import java.io.IOException;
import java.util.List;

import org.redis.manager.context.AppConstants;
import org.redis.manager.leveldb.D_ServerInfo;
import org.redis.manager.leveldb.LevelTable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ServerInfoService {
	
	/**
	 * 添加机器信息
	 */
	public void addService(D_ServerInfo server) throws Exception {
		LevelTable.put(AppConstants.LEVEL_DATABASES_SYSTEM, server);
	}
	
	/**
	 * 获取所有机器信息
	 * @return 
	 */
	public List<D_ServerInfo> getAllService() throws Exception {
		return LevelTable.getAll(AppConstants.LEVEL_DATABASES_SYSTEM, D_ServerInfo.class);
	}

	/**
	 * 获取指定机器信息
	 */
	public D_ServerInfo get(String ip) throws Exception {
		return LevelTable.get(AppConstants.LEVEL_DATABASES_SYSTEM, D_ServerInfo.class, ip);
	}
	
	/**
	 * 删除机器信息 
	 */
	public void delete(String ip) throws IOException {
		LevelTable.delete(AppConstants.LEVEL_DATABASES_SYSTEM, D_ServerInfo.class, ip);
	}
}