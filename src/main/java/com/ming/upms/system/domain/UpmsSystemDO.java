package com.ming.upms.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-04 13:04:29
 */
@ApiModel(value = "系统", description = "系统实体类")
public class UpmsSystemDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "编号")
	private Long systemId;

	@ApiModelProperty(value = "图标")
	private String icon;

	@ApiModelProperty(value = "背景")
	private String banner;

	@ApiModelProperty(value = "主题")
	private String theme;

	@ApiModelProperty(value = "根目录")
	private String basepath;

	@ApiModelProperty(value = "状态(-1:黑名单,1:正常)")
	private Integer status;

	@ApiModelProperty(value = "系统名称")
	private String name;

	@ApiModelProperty(value = "系统标题")
	private String title;

	@ApiModelProperty(value = "系统描述")
	private String description;

	@ApiModelProperty(value = "创建时间")
	private Date ctime;

	@ApiModelProperty(value = "排序")
	private Long orders;

	/**
	 * 设置：编号
	 */
	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}
	/**
	 * 获取：编号
	 */
	public Long getSystemId() {
		return systemId;
	}
	/**
	 * 设置：图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：背景
	 */
	public void setBanner(String banner) {
		this.banner = banner;
	}
	/**
	 * 获取：背景
	 */
	public String getBanner() {
		return banner;
	}
	/**
	 * 设置：主题
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}
	/**
	 * 获取：主题
	 */
	public String getTheme() {
		return theme;
	}
	/**
	 * 设置：根目录
	 */
	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}
	/**
	 * 获取：根目录
	 */
	public String getBasepath() {
		return basepath;
	}
	/**
	 * 设置：状态(-1:黑名单,1:正常)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态(-1:黑名单,1:正常)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：系统名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：系统名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：系统标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：系统标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：系统描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：系统描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCtime() {
		return ctime;
	}
	/**
	 * 设置：排序
	 */
	public void setOrders(Long orders) {
		this.orders = orders;
	}
	/**
	 * 获取：排序
	 */
	public Long getOrders() {
		return orders;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UpmsSystemDO{");
		sb.append("systemId=").append(systemId);
		sb.append(", icon='").append(icon).append('\'');
		sb.append(", banner='").append(banner).append('\'');
		sb.append(", theme='").append(theme).append('\'');
		sb.append(", basepath='").append(basepath).append('\'');
		sb.append(", status=").append(status);
		sb.append(", name='").append(name).append('\'');
		sb.append(", title='").append(title).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", ctime=").append(ctime);
		sb.append(", orders=").append(orders);
		sb.append('}');
		return sb.toString();
	}
}
