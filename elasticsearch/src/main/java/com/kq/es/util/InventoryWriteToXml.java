package com.kq.es.util;

import com.kq.entity.Inventory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * DomWriteUtil
 *
 * @author kq
 * @date 2019-10-23
 */
public class InventoryWriteToXml {

    /**
     * 生成xml方法
     */
    public static void createXml(List<Inventory> list) {
        try {
            // 创建解析器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            Document document = db.newDocument();
            // 不显示standalone="no"
            document.setXmlStandalone(false);
            Element studentsEle = document.createElement("students");

            int id = 0;
            for (Inventory stu : list) {
                id++;
                Element studentEle = document.createElement("student");
                // 为student节点添加属性
                studentEle.setAttribute("id", (id) + "");

                // 向studentEle节点中添加子节点age
                Element ageEle = document.createElement("bigCategoryName");
                ageEle.setTextContent(stu.getBigCategoryName() + "");
                studentEle.appendChild(ageEle);


                Element nameEle = document.createElement("name");
                nameEle.setTextContent(stu.getName());
                studentEle.appendChild(nameEle);

                Element codeEle = document.createElement("code");
                codeEle.setTextContent(stu.getCode());
                studentEle.appendChild(codeEle);


                Element smallCategoryNameEle = document.createElement("smallCategoryName");
                smallCategoryNameEle.setTextContent(stu.getSmallCategoryName());
                studentEle.appendChild(smallCategoryNameEle);

                Element orgIdEle = document.createElement("orgId");
                orgIdEle.setTextContent(stu.getOrgId());
                studentEle.appendChild(orgIdEle);

                Element statusEle = document.createElement("status");
                statusEle.setTextContent(stu.getStatus()+"");
                studentEle.appendChild(statusEle);

                Element mnemonicCodeEle = document.createElement("mnemonicCode");
                mnemonicCodeEle.setTextContent(stu.getMnemonicCode()+"");
                studentEle.appendChild(mnemonicCodeEle);

                //createTime
                Element createTimeEle = document.createElement("createTime");
                createTimeEle.setTextContent(stu.getCreateTime().getTime()+"");
                studentEle.appendChild(createTimeEle);

                studentsEle.appendChild(studentEle);
            }

            document.appendChild(studentsEle);

            // 创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();

            // 创建 Transformer对象
            Transformer tf = tff.newTransformer();
            // 输出内容是否使用换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            // 创建xml文件并写入内容
            File file = new File("inventory.xml");
            // 判断文件是否存在
            if (!file.exists()) {
                file.createNewFile();
            }
            System.out.println("inventory.xml path = " + file.getAbsolutePath());
            tf.transform(new DOMSource(document), new StreamResult(file));

            System.out.println("inventory.xml成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("inventory.xml失败");
        }
    }


//    public static void main(String[] args) {
////        createXml(StudentData.getStudentList());
//    }


}
