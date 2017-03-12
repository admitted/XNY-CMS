package me.cuijing.cms.authorities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.cuijing.cms.authorities.service.AuthoritiesService;

/**
 * <p>Title: AuthoritiesController</p>
 * <p>Description: 权限控制层</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
@Controller
@RequestMapping("/auth")
public class AuthoritiesController {
	
	@Autowired
	AuthoritiesService authoritiesService;
}
