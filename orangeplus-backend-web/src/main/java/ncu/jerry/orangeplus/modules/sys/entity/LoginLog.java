package ncu.jerry.orangeplus.modules.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 登录记录
 * </p>
 *
 * @author Jiacheng
 * @since 2017-08-23
 */
@TableName("login_log")
public class LoginLog extends Model<LoginLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 日志名称
     */
	@TableField("log_name")
	private String logName;
    /**
     * 管理员id
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 是否执行成功
     */
	private String succeed;
    /**
     * 具体消息
     */
	private String message;
    /**
     * 登录ip
     */
	private String ip;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSucceed() {
		return succeed;
	}

	public void setSucceed(String succeed) {
		this.succeed = succeed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "LoginLog{" +
			"id=" + id +
			", logName=" + logName +
			", userId=" + userId +
			", createTime=" + createTime +
			", succeed=" + succeed +
			", message=" + message +
			", ip=" + ip +
			"}";
	}
}
