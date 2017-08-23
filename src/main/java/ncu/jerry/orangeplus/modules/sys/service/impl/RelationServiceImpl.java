package ncu.jerry.orangeplus.modules.sys.service.impl;

import ncu.jerry.orangeplus.modules.sys.entity.Relation;
import ncu.jerry.orangeplus.modules.sys.mapper.RelationMapper;
import ncu.jerry.orangeplus.modules.sys.service.IRelationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author Jiacheng
 * @since 2017-08-23
 */
@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements IRelationService {
	
}
