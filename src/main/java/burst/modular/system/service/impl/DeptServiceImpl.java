package burst.modular.system.service.impl;

import burst.core.model.RequestData;
import burst.modular.system.entity.Dept;
import burst.modular.system.entity.Role;
import burst.modular.system.mapper.DeptMapper;
import burst.modular.system.mapper.RoleMapper;
import burst.modular.system.service.IDeptService;
import burst.modular.system.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yf.wang
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/3015:38
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
    @Override
    public int add(RequestData requestData) {
        return 0;
    }

    @Override
    public void delete(RequestData requestData) {

    }

    @Override
    public void update(RequestData requestData) {

    }

    @Override
    public List<Dept> list(RequestData requestData) {
        return null;
    }
}
