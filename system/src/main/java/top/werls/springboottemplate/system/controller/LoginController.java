package top.werls.springboottemplate.system.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.werls.springboottemplate.common.ResultData;
import top.werls.springboottemplate.common.SecurityRequirementConfig;
import top.werls.springboottemplate.system.param.LoginParam;
import top.werls.springboottemplate.system.service.SysUserService;
import top.werls.springboottemplate.system.vo.LoginVo;



@Slf4j
@RestController
@SecurityRequirement(name =  SecurityRequirementConfig.TOKEN_HEADER)
public class LoginController {

    @Resource
    private SysUserService userService;

    @PostMapping("/login")
    public ResultData<LoginVo> login(@RequestBody LoginParam param) {
        return ResultData.success(userService.login(param));
    }
}
