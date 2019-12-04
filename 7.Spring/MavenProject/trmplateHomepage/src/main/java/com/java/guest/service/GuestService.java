package com.java.guest.service;

import org.springframework.web.servlet.ModelAndView;

public interface GuestService {
	public void guestWrite(ModelAndView modelAndView);

	public void guestWriteOk(ModelAndView modelAndView);

	public void guestUpdate(ModelAndView modelAndView);

	public void guestUpdateOk(ModelAndView modelAndView);

	public void guestDelete(ModelAndView modelAndView);
}
