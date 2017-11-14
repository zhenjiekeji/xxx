package com.uk.sec.bns.client.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.bns.client.model.Tree;
import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.privilege.framework.privilege.dao.SecPrivilegeMenuDao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeMenu;

@Component
@Transactional
public class RoadManager extends BaseManager<SecPrivilegeMenu, java.lang.String> {

	@Autowired
	private SecPrivilegeMenuDao menuDao;

	public SecPrivilegeMenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(SecPrivilegeMenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	protected SecPrivilegeMenuDao getEntityDao() {
		return menuDao;
	}

	/**
	 * 获得管理处公路树
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Tree> getRoadTreeList(String id) throws Exception {
		List<Tree> treeList = new ArrayList<Tree>();
		List<SecPrivilegeMenu> menuList = null;
		if (StringUtils.isEmpty(id)) {
			SecPrivilegeMenu entity = new SecPrivilegeMenu();
			//entity.setMenuId("5bbd27b5a20211e4afd700163e000117");
			entity.setParentId("E06FF728CB84CA69E04014AC06126600");
			menuList = menuDao.findAll(entity);
		} else {
			menuList = menuDao.findMenuByLoginIdAndParentId(
					this.getLoginId(), id);
		}
		for (SecPrivilegeMenu menu : menuList) {
			Tree tree = new Tree();
			tree.setId(menu.getMenuId());
			tree.setText(menu.getMenuTitle());
			tree.setPid(menu.getParentId());
			tree.setUrl(menu.getMenuUrl());
			List<SecPrivilegeMenu> menuChildList = menuDao
					.findMenuByLoginIdAndParentId(this.getLoginId(),menu.getMenuId());
			if (menuChildList != null && menuChildList.size() > 0) {
				tree.setState("closed");
			}
			treeList.add(tree);
		}
		return treeList;
	}
	
	public List<Tree> getRoadTreeList() throws Exception {
		List<Tree> treeList = new ArrayList<Tree>();
		List<SecPrivilegeMenu> menuList = menuDao.findMenuByLoginIdAndParentId(
				this.getLoginId(), "E06FF728CB84CA69E04014AC06126600");
		List<Tree> dataList = converTree(menuList);
		if (dataList != null && dataList.size() > 0) {
			treeList = renderChildrenTree(dataList);
		}
		return treeList;
	}
	
	 /**
     * 递归获取树
     *
     * @param orgList
     * @return
     * @throws Exception
     * @author:chengqiang
     */
    public List<Tree> renderChildrenTree(List<Tree> dataList) throws Exception {
    	for (Tree tree : dataList) {
			List<SecPrivilegeMenu> menuList = menuDao
				.findMenuByLoginIdAndParentId(this.getLoginId(),tree.getId());
		    List<Tree> childrens = converTree(menuList);
		    tree.setChildren(childrens);
            renderChildrenTree(childrens);
		}
    	return dataList;
    }
    
    /**
     * 转化成树对象
     * @param menuList
     * @return
     */
    private List<Tree> converTree(List<SecPrivilegeMenu> menuList) {
    	List<Tree> treeList = new ArrayList<Tree>();
    	for (SecPrivilegeMenu menu : menuList) {
			Tree tree = new Tree();
			tree.setId(menu.getMenuId());
			tree.setText(menu.getMenuTitle());
			tree.setPid(menu.getParentId());
			tree.setUrl(menu.getMenuUrl());
			List<SecPrivilegeMenu> menuChildList = menuDao
					.findMenuByLoginIdAndParentId(this.getLoginId(),menu.getMenuId());
			if (menuChildList != null && menuChildList.size() > 0) {
				tree.setState("closed");
			}
			treeList.add(tree);
		}
    	return treeList;
    }

}
