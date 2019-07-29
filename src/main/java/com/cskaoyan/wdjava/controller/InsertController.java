/**
 * User: lgl
 * Date: 2019-07-25
 * Time: 22:36
 */
package com.cskaoyan.wdjava.controller;

import com.cskaoyan.wdjava.bean.WdStudentInsert;
import com.cskaoyan.wdjava.mapper.WdInsertMapper;
import com.cskaoyan.wdjava.service.WdInsertService;
import com.cskaoyan.wdjava.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("insert")
public class InsertController {

    @Value("${wd.img.file.uploadPath}")
    String filePath;

    @Autowired
    WdInsertService insertService;


    @RequestMapping(value = "image",method = RequestMethod.POST)
    @ResponseBody
    public String importImage(@RequestParam("img") MultipartFile img, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        String trueFileName = "";
        try {

            if (img.isEmpty()){
                return "上传为空";
            }

            if (img!=null) {// 判断上传的文件是否为空
                String path=null;// 文件路径
                String type=null;// 文件类型
                String fileName=img.getOriginalFilename();// 文件原名称
                System.out.println("上传的文件原名称:"+fileName);
                // 判断文件类型
                type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
                if (type!=null) {// 判断文件类型是否为空
                    if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                        // 项目在容器中实际发布运行的根路径
                        //String realPath=request.getServletContext().getRealPath("/static/image");

                        // 自定义的文件名称
                        trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
                        // 设置存放图片文件的路径
                        path=filePath + trueFileName;
                        System.out.println("存放图片文件的路径:"+path);
                        // 转存文件到指定的路径
                        img.transferTo(new File(path));
                        System.out.println("文件成功上传到指定目录下");
                    }else {
                        System.out.println("不是我们想要的文件类型,请按要求重新上传");
                        return null;
                    }
                }else {
                    System.out.println("文件类型为空");
                    return null;
                }
            }else {
                System.out.println("没有找到相对应的文件");
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/static/image/" + trueFileName;
    }


    @RequestMapping(value = "/insertStudentMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result insertStudentMessage(WdStudentInsert objInsert){
        try{
       boolean bool = insertService.insertStudentMessage(objInsert);
        }catch (Exception e){
            e.printStackTrace();
        }

        Map<String,Object> map = new HashMap<>();



        Result result = new Result();
        result.setFailMsg("****数据不对"); // 核对数据,有空再做
        result.setRet(true);
        return result;
    }

    @RequestMapping(value = "/update/updateStudentMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result updateStudentMessage(WdStudentInsert objInsert){
        try{
            boolean bool = insertService.updateStudentMessage(objInsert);
        }catch (Exception e){
            e.printStackTrace();
        }

        Map<String,Object> map = new HashMap<>();



        Result result = new Result();
        result.setFailMsg("****数据不对"); // 核对数据,有空再做
        result.setRet(true);
        return result;
    }


}
