package jp.co.intellisea.oc.web.sales.form.bean;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AccountForm {
	
	/**
	 * 取引名
	 */
	private String name;
	
	
	@NotNull
	private String address1;
	
	private String address2;
	
	private String address3;
	
	private String phone_number;
	
	private String homepage;
	
	private String ipc_type;

}
