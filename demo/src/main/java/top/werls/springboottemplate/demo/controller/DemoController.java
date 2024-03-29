package top.werls.springboottemplate.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.webmvc.ui.SwaggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.werls.springboottemplate.Mmo;
import top.werls.springboottemplate.common.ResultData;
import top.werls.springboottemplate.common.SecurityRequirementConfig;
import top.werls.springboottemplate.common.utils.MessageUtils;



/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/30
 */
@RestController("/demo")
@SecurityRequirement(name = SecurityRequirementConfig.TOKEN_HEADER)
@Tag(name = "DemoApi", description = "the DemoApi API")
@Slf4j
public class DemoController {

    @Resource
    public Mmo mmo;


    @GetMapping("/i")
    public ResultData<String> demo(){
        return ResultData.success("this is  demo mod");
    }
    @Autowired
    private MessageUtils messageUtils;

    @Operation(summary = "getDemo", description = "getDemo")
    @GetMapping(value = "/demo")
    public String getHello() {
        log.error(" hhhhhh ");
        return "Hello World!"+ mmo.getName();
    }

    @Operation(summary = "get", description = "success")
    @GetMapping(value = "/success")
    public String getDemo() {
        return "Hello World!" + messageUtils.getMessage("success");
    }

}
