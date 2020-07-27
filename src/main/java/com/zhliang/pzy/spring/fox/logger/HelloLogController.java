package com.zhliang.pzy.spring.fox.logger;

import com.zhliang.pzy.pzy.log.aspect.AuditLog;
import com.zhliang.pzy.pzy.log.response.R;
import com.zhliang.pzy.pzylog.client.Logger;
import com.zhliang.pzy.pzylog.client.LoggerFactory;
import com.zhliang.pzy.pzylog.client.enums.LogEventTypeEnum;
import com.zhliang.pzy.pzylog.client.enums.LogLevelEnum;
import com.zhliang.pzy.pzylog.client.enums.LogOperateTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类描述：
 */
@Api(tags="日志管理")
@RestController
@RequestMapping("/log")
public class HelloLogController {

    private static final Logger logger = LoggerFactory.getLogger(HelloLogController.class);


    @ApiOperation("测试日志")
    @GetMapping("hello")
    @AuditLog(level = LogLevelEnum.LEVEL_LOW, eventType = LogEventTypeEnum.EVENT_BUSINESS, operateObject = "hello get print", operateType = LogOperateTypeEnum.OPERATE_QUERY)
    public R<String> helloLog(){
        logger.audit("hello log print");
        logger.info("hello log print");
        return R.success();
    }
}
