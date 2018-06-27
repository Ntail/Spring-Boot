package cn.timebusker.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class SystemRole implements Serializable {

    private static final long serialVersionUID = -5897208774026193298L;

    private Integer roleId;

    private String roleName;

    private Date updateDate;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
