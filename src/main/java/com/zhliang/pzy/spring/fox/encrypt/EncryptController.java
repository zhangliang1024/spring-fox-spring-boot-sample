package com.zhliang.pzy.spring.fox.encrypt;

import com.pzy.zhliang.api.encrypt.annotation.Decrypt;
import com.pzy.zhliang.api.encrypt.annotation.Encrypt;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptController {

	//@Encrypt
	@Decrypt
	@GetMapping("/encryptStr")
	public String encryptStr(String name) {
		System.out.println(name);
		return "加密字符串";
	}


	@PostMapping("/encryptStr")
	public String encryptStr2(String name) {
		System.out.println(name);
		return "加密字符串";
	}
	
	@Encrypt
	@PostMapping("/encryptEntity")
	public UserDto encryptEntity() {
		UserDto dto = new UserDto();
		dto.setId(1);
		dto.setName("加密实体对象");
		return dto;
	}
	
	@Encrypt
	@Decrypt
	@PostMapping("/save")
	public UserDto save(@RequestBody UserDto dto) {
		System.err.println(dto.getId() + "\t" + dto.getName());
		return dto;
	}
	
	@GetMapping(value="decryptEntityJson",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String decryptEntityXml(@RequestBody UserDto dto) {
		System.err.println(dto.getId() + "\t" + dto.getName());
		return dto.getName();
	}
	
}
