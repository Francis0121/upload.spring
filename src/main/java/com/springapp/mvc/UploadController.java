package com.springapp.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/")
public class UploadController {

	@Autowired
	private UploadService uploadService;

	private static Logger logger = LoggerFactory.getLogger(UploadController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String index(@ModelAttribute Upload upload) {

		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String upload(@ModelAttribute Upload upload, BindingResult result){
		new Validator(){
			@Override
			public boolean supports(Class<?> clazz) {
				return Upload.class.isAssignableFrom(clazz);
			}

			@Override
			public void validate(Object target, Errors errors) {
				Upload upload = (Upload) target;

				if(upload.getFile().isEmpty()){
					errors.rejectValue("file", "upload.file.empty");
				}
			}
		}.validate(upload, result);

		if(result.hasErrors()){
			return "index";
		}

		CommonsMultipartFile file = upload.getFile();
		upload.setPath(uploadService.transferFile(file, file.getOriginalFilename()));
		logger.debug("upload post" + upload);

		return "redirect:/";
	}

}