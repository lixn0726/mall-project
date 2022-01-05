package com.project.mallproject.core.aspect;

import com.project.mallproject.core.annotation.SysLogBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Description:
 * date: 2021/10/25 5:41 下午
 *
 * @author lixn
 */
@Service
public class SysLogService {
    private static final Logger log = LoggerFactory.getLogger(SysLogService.class);

    public boolean save(SysLogBo sysLogBo) {
        log.info(sysLogBo.getParams());
        System.out.println(sysLogBo.toString());
        return true;
    }
}
