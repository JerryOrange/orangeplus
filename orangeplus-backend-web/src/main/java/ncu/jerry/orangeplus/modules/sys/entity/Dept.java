package ncu.jerry.orangeplus.modules.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author Jiacheng
 * @since 2017-08-23
 */
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 排序
     */
	private Integer num;
    /**
     * 父部门id
     */
	@TableField("p_id")
	private Integer pId;
    /**
     * 父级ids
     */
	@TableField("p_ids")
	private String pIds;
    /**
     * 简称
     */
	@TableField("simple_name")
	private String simpleName;
    /**
     * 全称
     */
	@TableField("full_name")
	private String fullName;
    /**
     * 提示
     */
	private String tips;
    /**
     * 版本（乐观锁保留字段）
     */
	private Integer version;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpIds() {
		return pIds;
	}

	public void setpIds(String pIds) {
		this.pIds = pIds;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Dept{" +
			"id=" + id +
			", num=" + num +
			", pId=" + pId +
			", pIds=" + pIds +
			", simpleName=" + simpleName +
			", fullName=" + fullName +
			", tips=" + tips +
			", version=" + version +
			"}";
	}
}
