package jp.co.intellisea.oc.web.sales.service.impl;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import jp.co.intellisea.oc.web.sales.dao.ContactMapper;
import jp.co.intellisea.oc.web.sales.entity.Contact;
import jp.co.intellisea.oc.web.sales.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public boolean addContact(Contact contact){
        return contactMapper.insert(contact) > 0;
    }

    @Override
    public List<Contact> allContact() {
        List<Contact> contacts = contactMapper.allContact(); 
        System.out.println(contacts);
        return contacts; 
    }

    @Override
    public Contact selectContactByPrimaryKey(Integer contactId) { return contactMapper.selectByPrimaryKey(contactId); }

    @Override
    public boolean deleteContactByPrimaryKey(Integer contactId) { return contactMapper.deleteByPrimaryKey(contactId) > 0; }

    @Override
    public boolean updatePrimaryKey(Contact record) { return contactMapper.updateByPrimaryKey(record) > 0; }

    @Override
    public List<Contact> selectByFuzzySearch(String search) { return contactMapper.selectByFuzzySearch(search); }

    @Override
    public byte[] generateContactPdfFromContact() {
        // 获取数据库中的所有联系人
        List<Contact> contacts = contactMapper.allContact();

        // 创建一个内存中的 PDF 输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            // 创建文档对象
            Document document = new Document();
            PdfWriter.getInstance(document, byteArrayOutputStream); // 获取 PdfWriter 实例并绑定文档

            document.open();  // 打开文档以便写入内容

            // 创建一个表格来展示联系人信息，假设 Contact 有 4 个字段：ID, 姓名, 电话, 邮箱
            PdfPTable table = new PdfPTable(4);  // 4 列表格
            table.addCell("ID");
            table.addCell("Name");
            table.addCell("Phone");
            table.addCell("Email");

            // 遍历联系人数据并将其填充到表格中
            for (Contact contact : contacts) {
                table.addCell(contact.getContactId().toString());
                table.addCell(contact.getName());
                table.addCell(contact.getPhoneNumber());
                table.addCell(contact.getMail());
            }

            // 将表格添加到 PDF 文档中
            document.add(table);
            document.close();  // 完成 PDF 生成

        } catch (DocumentException e) {
            // 捕获 DocumentException 异常，记录异常信息或者进行其他处理
            e.printStackTrace();  // 打印堆栈跟踪信息，或者记录日志
            return null;  // 或者返回一个空值，表示生成 PDF 失败
        }

        // 返回字节数组（PDF 内容）
        return byteArrayOutputStream.toByteArray();
    }

}
