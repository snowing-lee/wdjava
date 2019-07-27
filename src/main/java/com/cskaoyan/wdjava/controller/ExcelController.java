/**
 * User: zsquirrel
 * Date: 2019-07-24
 * Time: 16:36
 */
package com.cskaoyan.wdjava.controller;

import com.cskaoyan.wdjava.bean.WdStudentInfo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("excel")
public class ExcelController {

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    @ResponseBody
    public String importExcel(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "上传失败，请选择文件";
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            //HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                List<WdStudentInfo> wdStudentInfoList = processSheet(sheet);

            }
        } catch (IOException e) {
            e.printStackTrace();
            return "上传解析失败";
        }
        return "上传解析成功";
    }

    private List<WdStudentInfo> processSheet(XSSFSheet sheet) {
        int rows = sheet.getPhysicalNumberOfRows();
        List<WdStudentInfo> wdStudentInfoList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            if(i == 0){
                continue;
            }
            XSSFRow row = sheet.getRow(i);
            int cells = row.getPhysicalNumberOfCells();
            WdStudentInfo studentInfo = new WdStudentInfo();
            for (int j = 0; j < cells; j++) {
                XSSFCell cell = row.getCell(j);
                if(cell == null){
                    continue;
                }
                switch (j){
                    case 1:
                        //姓名
                        String stringCellValue = cell.getStringCellValue();
                        System.out.println(stringCellValue);
                        studentInfo.setStuName(cell.getStringCellValue().trim());
                        break;
                    case 3:
                        //电话号码
                        //row.getCell(j).setCellType();
                        //String phone = NumberToTextConverter.toText(cell.getNumericCellValue());
                        DecimalFormat format = new DecimalFormat("0");
                        String phone = format.format(cell.getNumericCellValue());
                        System.out.println(phone);
                        studentInfo.setMobile(phone);
                        break;
                    case 5:
                        //学校
                        String stringCellValue1 = cell.getStringCellValue();
                        System.out.println(stringCellValue1);
                        studentInfo.setSchool(cell.getStringCellValue().trim());
                        break;
                    case 6:
                        //专业
                        String stringCellValue2 = cell.getStringCellValue();
                        System.out.println(stringCellValue2);
                        studentInfo.setMajor(cell.getStringCellValue().trim());
                        break;
                    case 7:
                        studentInfo.setGraduateYear((int)cell.getNumericCellValue());
                        break;
                    case 8:
                        //studentInfo.setIdNo(cell.getStringCellValue().trim());
                        break;
                    case 9:
                        studentInfo.setComment(cell.getStringCellValue().trim());
                        break;
                    default:
                        break;

                }

            }
            wdStudentInfoList.add(studentInfo);
        }
        return wdStudentInfoList;
    }


}
