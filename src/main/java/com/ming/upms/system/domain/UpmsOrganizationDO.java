package com.ming.upms.system.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;



/**
 * 组织
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 14:29:52
 */
@ApiModel(value = "组织", description = "组织实体类")
public class UpmsOrganizationDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "编号")
	private Long organizationId;

	@ApiModelProperty(value = "组织名称")
	private String name;

	@ApiModelProperty(value = "所属上级")
	private Long pid;

	@ApiModelProperty(value = "上级名称")
	private String pName;

	@ApiModelProperty(value = "组织描述")
	private String description;

	@ApiModelProperty(value = "创建时间")
	private Date ctime;

	/**
	 * 设置：编号
	 */
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	/**
	 * 获取：编号
	 */
	public Long getOrganizationId() {
		return organizationId;
	}
	/**
	 * 设置：所属上级
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：所属上级
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * 设置：组织名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：组织名称
	 */
	public String getName() {
		return name;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	/**
	 * 设置：组织描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：组织描述
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UpmsOrganizationDO{");
		sb.append("organizationId=").append(organizationId);
		sb.append(", pid=").append(pid);
		sb.append(", name='").append(name).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", ctime=").append(ctime);
		sb.append('}');
		return sb.toString();
	}
}
