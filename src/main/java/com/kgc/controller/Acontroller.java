package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Atuthor;
import com.kgc.entity.Bookinfo;
import com.kgc.entity.Name;
import com.kgc.entity.Users;
import com.kgc.service.AtuthorService;
import com.kgc.service.BookinfoService;
import com.kgc.service.NameService;
import com.kgc.service.UsersService;
import com.kgc.utils.BookParam;
import com.kgc.utils.UsersParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class Acontroller {
    @Autowired
    private AtuthorService atuthorService;
    @Autowired
    private BookinfoService bookinfoService;
    @Autowired
    private NameService nameService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/ling",method = RequestMethod.GET)
    public String ling(){
        return "ling";
    }
    @RequestMapping(value = "/ling",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String ling(UsersParam usersParam, HttpSession session){
        List<Users> users = usersService.getUsers( usersParam );
        if(!usersParam.getUsercode().equals( "" )&&!usersParam.getPassword().equals( "" )){
            if(users!=null&&users.size()>0){
                session.setAttribute( "usercode",usersParam.getUsercode() );
                String url="/index";
                return "<script>alert('登陆成功');location.href='"+url+"'</script>";
            }
        }
        return "<script>alert('登陆失败');history.go(-1)</script>";
    }
    @RequestMapping("index")
    public String index(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                        @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                        BookParam bookParam,
                        HttpSession session,
                        Model model){
        Object usercode = session.getAttribute( "usercode" );
        if(usercode!=null){
            PageInfo<Bookinfo> bookPage = bookinfoService.getBookPage( pageIndex, pageSize, bookParam );
            List<Name> nameList = nameService.getNameLisr();

            model.addAttribute( "bookPage",bookPage );
            model.addAttribute( "nameList",nameList );
            model.addAttribute( "bookParam",bookParam );
            return "index";
        }
        return "redirect:ling";
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        List<Atuthor> atuthorList = atuthorService.getAtuthorList();
        List<Name> nameList = nameService.getNameLisr();
        model.addAttribute( "atuthorList",atuthorList );
        model.addAttribute( "nameList",nameList );
        return "add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST,produces ="text/html;charset=UTF-8" )
    @ResponseBody
    public String add(Bookinfo bookinfo) {
        if (bookinfoService.add( bookinfo )) {
            String url = "/index";
            return "<script>alert('添加成功');location.href='" + url + "'</script>";
        } else {
            return "<script>alert('添加失败');history.go(-1)</script>";
        }
    }
}
