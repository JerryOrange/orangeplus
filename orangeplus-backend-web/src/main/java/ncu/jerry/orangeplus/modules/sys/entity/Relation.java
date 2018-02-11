package ncu.jerry.orangeplus.modules.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author Jiacheng
 * @since 2017-08-23
 */
public class Relation extends Model<Relation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 菜单id
     */
	@TableField("menu_id")
	private Integer menuId;
    /**
     * 角色id
     */
	@TableField("role_id")
	private Integer roleId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Relation{" +
			"id=" + id +
			", menuId=" + menuId +
			", roleId=" + roleId +
			"}";
	}
}
