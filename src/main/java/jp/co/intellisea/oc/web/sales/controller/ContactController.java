package jp.co.intellisea.oc.web.sales.controller;

import com.alibaba.fastjson.JSONObject;
import jp.co.intellisea.oc.web.sales.common.ErrorMessage;
import jp.co.intellisea.oc.web.sales.common.SuccessMessage;
import jp.co.intellisea.oc.web.sales.entity.Contact;
import jp.co.intellisea.oc.web.sales.service.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactServiceImpl contactService;

    @ResponseBody
    @RequestMapping(value = "/contact/add", method = RequestMethod.POST)
    public JSONObject addContact(HttpServletRequest req,
                                 @RequestParam("contact_id") Integer contactId,
                                 @RequestParam("name") String name,
                                 @RequestParam("phone_number") String phoneNumber,
                                 @RequestParam("mail") String mail,
                                 @RequestParam("duties") String duties
                           ){
        Contact contact = new Contact();
        contact.setContactId(contactId);
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        contact.setMail(mail);
        contact.setDuties(duties);
        boolean res = contactService.addContact(contact);
        if(res)
            return new SuccessMessage("add contact successful!", true).getMessage();
        return new ErrorMessage("add contact error.").getMessage();
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public JSONObject allContact(){return new  SuccessMessage< List<Contact>>(null, contactService.allContact()).getMessage();}


    @RequestMapping(value = "/contact/search", method = RequestMethod.GET)
    public JSONObject searchContact(@RequestParam String query) {
        return new SuccessMessage< List<Contact>>(null, contactService.selectByFuzzySearch(query)).getMessage();
    }


    @RequestMapping(value = "/contact/delete", method = RequestMethod.DELETE)
    public JSONObject deleteContact(HttpServletRequest req,
                                    @RequestParam("id") Integer contactId){
        boolean res = contactService.deleteContactByPrimaryKey(contactId);
        if(res)
            return new SuccessMessage("delete contact successful!", true).getMessage();
        return new ErrorMessage("delete contact error.").getMessage();
    }

    @RequestMapping(value = "/contact/update", method = RequestMethod.POST)
    public JSONObject updateContact(HttpServletRequest req,
                                 @RequestParam("contact_id") Integer contactId,
                                 @RequestParam("name") String name,
                                 @RequestParam("phone_number") String phoneNumber,
                                 @RequestParam("mail") String mail,
                                 @RequestParam("duties") String duties
    ){
        Contact contact = new Contact();
        contact.setContactId(contactId);
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        contact.setMail(mail);
        contact.setDuties(duties);
        boolean res = contactService.updatePrimaryKey(contact);
        if(res)
            return new SuccessMessage("add contact successful!", true).getMessage();
        return new ErrorMessage("add contact error.").getMessage();
    }
    @GetMapping("/contact/pdfOfContact")
    public ResponseEntity<byte[]> generateContactPdf() throws IOException {
        // 调用 service 层的 generateContactPdfFromContact 方法生成 PDF
        byte[] pdfContent = contactService.generateContactPdfFromContact();

        if (pdfContent == null) {
            // 如果 PDF 生成失败，返回 500 错误
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        // 设置响应头，指示这是一个 PDF 文件
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=contacts.pdf");
        headers.add("Content-Type", "application/pdf");

        // 返回 PDF 内容和相应的 HTTP 状态码
        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}