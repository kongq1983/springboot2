package com.kq.es.util;

import com.kq.entity.Inventory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DomParseXmlUtil
 *
 * @author kq
 * @date 2019-10-24
 */
public class DomParseXmlUtil {

    private static boolean validating = false;

    private static void parseStudentContent(Element bookEle, Inventory inventory) {

        NodeList list = bookEle.getChildNodes();

        StringBuilder str = new StringBuilder();
        for(int i=0;i<list.getLength();i++) {
            Node node = list.item(i);
            if(node.getNodeType()!=Node.ELEMENT_NODE){
                System.out.println("ignore node = "+node);
                continue;
            }
            String value = getBodyDada(node.getFirstChild());
            System.out.println("index="+i+"  node="+node+" nodeType="+node.getNodeType());
            if(node.getNodeName().equals("bigCategoryName")){
                inventory.setBigCategoryName(value);
            }else if(node.getNodeName().equals("name")){
                inventory.setName(value);
            }else if(node.getNodeName().equals("code")){
                inventory.setCode(value);
            }else if(node.getNodeName().equals("smallCategoryName")){
                inventory.setSmallCategoryName(value);
            }else if(node.getNodeName().equals("orgId")){
                inventory.setOrgId(value);
            }else if(node.getNodeName().equals("status")){
                inventory.setStatus(Integer.parseInt(value));
            }else if(node.getNodeName().equals("mnemonicCode")){
                inventory.setMnemonicCode(value);
            }else if(node.getNodeName().equals("createTime")){
                inventory.setCreateTime(new Date(Long.valueOf(value)));
            }

        }
        System.out.println("student content="+str.toString());

    }

    private static String getBodyDada(Node n) {
        if(n==null) {
            return null;
        }

        if(n.getNodeType()==Node.CDATA_SECTION_NODE||n.getNodeType()==Node.TEXT_NODE){
            String data = ((CharacterData)n).getData();
            return data;
        }
        return null;
    }

    public static List<Inventory> dealStudent(Node studentNode) {
        NodeList bookList = studentNode.getChildNodes();

        System.out.println("studentList.size="+bookList.getLength());

        List<Inventory> list = new ArrayList<>();

        for (int i = 0; i < bookList.getLength(); i++) {
            Node item = bookList.item(i);
            String name = item.getNodeName();
            String value = item.getNodeValue();
            System.out.println("studentPos="+i + " node_name=" + name + " value=" + value+ " nodeType:"+item.getNodeType());
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element bookItem = (Element) item;

                Inventory inventory = new Inventory();
                String id = bookItem.getAttribute("id");
                inventory.setId(id);
                System.out.println(bookItem);
                System.out.println("studentIndex="+i + " node_name=" + name + " value=" + value + " id=" + id + " nodeType=" + bookItem.getNodeType());

                parseStudentContent(bookItem,inventory);

                list.add(inventory);
            }
        }

        return list;

    }


    public static List<Inventory> read(InputStream in) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        factory.setValidating(validating);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(in);
        document.getDocumentElement().normalize();
        Node node = document.getFirstChild();

        System.out.println("first node=" + node);
        System.out.println("name=" + node.getNodeName() + " value=" + node.getNodeValue());

        List<Inventory> studentList = dealStudent(node);

        System.out.println("  ========================= studentList.size="+studentList.size());
        studentList.forEach(System.out::println);

        return studentList;

    }

    public static List<Inventory> start() throws Exception {
        InputStream in = DomParseXmlUtil.class.getResourceAsStream("/inventory.xml");
        List<Inventory> list = null;
        try {
            list = read(in);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }


    public static void main(String[] args) throws Exception {

        InputStream in = DomParseXmlUtil.class.getResourceAsStream("/inventory.xml");
        try {
            read(in);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
