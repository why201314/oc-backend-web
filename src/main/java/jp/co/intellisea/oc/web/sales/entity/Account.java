package jp.co.intellisea.oc.web.sales.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {
    private Integer accountId;

    private String name;

    private String address1;

    private String address2;

    private String address3;

    private String phoneNumber;

    private String homepage;

    private String ipcType;

}