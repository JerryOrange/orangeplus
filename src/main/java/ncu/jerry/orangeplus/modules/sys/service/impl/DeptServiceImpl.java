package ncu.jerry.orangeplus.modules.sys.service.impl;

import ncu.jerry.orangeplus.modules.sys.entity.Dept;
import ncu.jerry.orangeplus.modules.sys.mapper.DeptMapper;
import ncu.jerry.orangeplus.modules.sys.service.IDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author Jiacheng
 * @since 2017-08-23
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
	
}
