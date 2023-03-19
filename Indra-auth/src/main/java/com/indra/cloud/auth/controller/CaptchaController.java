package com.indra.cloud.auth.controller;

import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import com.indra.cloud.common.response.ServerResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FrozenWatermelon
 * @date 2020/7/30
 */
@RestController
@RequestMapping("/ua/captcha")
public class CaptchaController {

	private final CaptchaService captchaService;

	public CaptchaController(CaptchaService captchaService) {
		this.captchaService = captchaService;
	}

	@PostMapping({ "/get" })
	public ServerResponseEntity<ResponseModel> get(@RequestBody CaptchaVO captchaVO) {
		return ServerResponseEntity.success(captchaService.get(captchaVO));
	}

	@PostMapping({ "/check" })
	public ServerResponseEntity<ResponseModel> check(@RequestBody CaptchaVO captchaVO) {
		return ServerResponseEntity.success(captchaService.check(captchaVO));
	}

}
