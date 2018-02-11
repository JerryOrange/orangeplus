package ncu.jerry.orangeplus.modules.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 通知表
 * </p>
 *
 * @author Jiacheng
 * @since 2017-08-23
 */
public class Notice extends Model<Notice> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 标题
     */
	private String title;
    /**
     * 类型
     */
	private Integer type;
    /**
     * 内容
     */
	private String content;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 创建人
     */
	private Integer creater;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreater() {
		return creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Notice{" +
			"id=" + id +
			", title=" + title +
			", type=" + type +
			", content=" + content +
			", createTime=" + createTime +
			", creater=" + creater +
			"}";
	}
}
