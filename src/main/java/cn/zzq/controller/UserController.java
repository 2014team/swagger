package cn.zzq.controller;
 
import cn.zzq.bean.JsonResult;
import cn.zzq.bean.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(value="User的相关信息接口",description="User的相关信息接口", protocols="http")
@RestController
public class UserController {

    @ApiOperation(notes="获取所有user，无需参数",value="获取所有user", httpMethod = "GET")
    @GetMapping("/getAll")
    public Object getAll(){
        //查出的所有部门信息
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setAge(23);
        user.setGender("男");
        user.setName("zhangsan");
        user.setPassword("123456");
        list.add(user);
        return list;
    }

    @ApiOperation(value="获取单个user", notes="参数非json格式",httpMethod = "POST")
    @PostMapping("/getOne")
    public Object getOne(@RequestBody @Valid User user, BindingResult result){
        JsonResult jsonResult = new JsonResult();
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for(int i=0;i<fieldErrors.size();i++){
                //控制台打印不符合校验的字段名和错误提示
                System.out.println("error field is :"+fieldErrors.get(i).getField()+",message is :"+fieldErrors.get(i).getDefaultMessage());
                String errorMsg = fieldErrors.get(i).getDefaultMessage();
                if(!StringUtils.isEmpty(errorMsg)){
                    jsonResult.setFailure(HttpStatus.BAD_REQUEST.value(),errorMsg);
                    return jsonResult;
                }
            }
        }
        jsonResult.setFailure(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase());
        return jsonResult;
    }


    @ApiOperation(value="根据名称获取user",notes="传入json格式")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "请求失败,后台服务出现异常"),
            @ApiResponse(code = 401, message = "代表此操作无权限访问"),
            @ApiResponse(code = 400, message = "表示请求参数错误"),
    })

    @PostMapping("/getOneByName")
    public Object getOneByName(@ApiParam(value = "用户名", required = true)  @RequestBody  String name){
        User u = new User();
        u.setAge(23);
        u.setGender("男");
        u.setName(name);
        u.setPassword("123456");
        return u;
    }

    @ApiOperation(value="修改用户",notes="参数非json格式", httpMethod="POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "name", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "possword", value = "密码", required = true, dataType = "String")
    })
    @PostMapping("/update")
    public Object update(String name,String possword){
        User u = new User();
        u.setAge(23);
        u.setGender("男");
        u.setName(name);
        u.setPassword(possword);
        return u;
    }
}
